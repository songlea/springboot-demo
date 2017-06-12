package com.songlea.springboot.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songlea.springboot.demo.mapper.HostCompareModelMapper;
import com.songlea.springboot.demo.model.HostCompareModel;
import com.songlea.springboot.demo.service.TableDataService;
import com.songlea.springboot.demo.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取表格数据Controller,各个模板界面统一
 *
 * @author Song Lea
 */
@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping("/table")
public class TableDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableDataController.class);

    private TableDataService tableDataService;
    private HostCompareModelMapper hostCompareModelMapper;

    public TableDataController() {
    }

    @Autowired
    public TableDataController(TableDataService tableDataService, HostCompareModelMapper hostCompareModelMapper) {
        Assert.notNull(tableDataService, "TableDataController.tableDataService must be not null!");
        Assert.notNull(hostCompareModelMapper, "TableDataController.hostCompareModelMapper must be not null!");
        this.tableDataService = tableDataService;
        this.hostCompareModelMapper = hostCompareModelMapper;
    }

    @RequestMapping(value = "/queryTableData")
    public Map<String, Object> queryTableData(String name, String compareStatus, String startTime,
                                              String endTime, int limit, int offset, String sort, String order) {
        return tableDataService.queryTableData(name, compareStatus, startTime, endTime,
                limit, offset, sort, order);
    }

    // Mybatis+pageHelper的请求示例
    @RequestMapping(value = "/queryMybatisTableData")
    public Map<String, Object> queryTableDataByMybatis(String name, String compareStatus, String startTime,
                                                       String endTime, int limit, int offset, String sort, String order) {
        LOGGER.info("通过Mybatis来获取请求数据！");
        String handlerName = name != null ? name.trim() : null;
        String handlerSort = "name".equals(sort) ? "NAME " : "INM_SYNC_TIME ";
        // 在bootstrap-table插件请求中offset为请求的开始位置,而不是页数,故需要计算页数
        int page = offset / limit + 1;
        PageHelper.startPage(page, limit); // 需要进行分页配置(分页插件)
        List<HostCompareModel> list = hostCompareModelMapper.selectHostCompareByCondition(handlerName,
                compareStatus, startTime, endTime, handlerSort, order);
        Map<String, Object> map = new HashMap<>();
        map.put(SecurityUtils.TABLE_ROWS, list);
        // PageInfo包含了如以下相关的分页属性:
        // pageInfo.getStartRow(); pageInfo.getPageNum(); pageInfo.getPageSize(); pageInfo.getStartRow();
        // pageInfo.getEndRow(); pageInfo.getPages(); pageInfo.getFirstPage(); pageInfo.getLastPage(); pageInfo.getTotal();
        // pageInfo.isFirstPage(); pageInfo.isLastPage(); pageInfo.isHasPreviousPage(); pageInfo.isHasNextPage();
        PageInfo<HostCompareModel> pageInfo = new PageInfo<>(list);
        map.put(SecurityUtils.TABLE_TOTAL, pageInfo.getTotal());
        return map;
    }

}
