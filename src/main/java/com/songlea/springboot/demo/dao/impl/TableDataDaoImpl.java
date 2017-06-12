package com.songlea.springboot.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.songlea.springboot.demo.dao.TableDataDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.songlea.springboot.demo.model.HostCompareModel;
import com.songlea.springboot.demo.util.SecurityUtils;

/**
 * 数据Dao层实现
 * 
 * @author Song Lea
 */
@Repository
public class TableDataDaoImpl implements TableDataDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TableDataDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

    public TableDataDaoImpl() {}

    @Autowired
    public TableDataDaoImpl(JdbcTemplate jdbcTemplate) {
        Assert.notNull(jdbcTemplate, "SyncHostDaoImpl.jdbcTemplate must be not null!");
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public Map<String, Object> queryTableData(String name, String compareStatus, String startTime,
			String endTime, int limit, int offset, String sort, String order) {
		StringBuilder rows = new StringBuilder();
		// 拼接sql会导致SQL注入攻击,生产环境下需使用变量绑定,此处未处理
        rows.append("SELECT r.ID,r.NAME,r.HOST_NAME,r.MANAGE_IP,r.CPU_FAMILY,r.OPERATE_SYSTEM,r.OS_VERSION,r.SERIAL_NUMBER,");
        rows.append("r.MANUFACTURER_TEXT,r.PHYSICAL_CPUS,r.MEMORY_SIZE,r.DISK_COUNT,r.TOTAL_DISK_SIZE,r.HOST_ID,r.INM_COMPARE_STATE,");
        rows.append("TO_CHAR(r.INM_SYNC_TIME,'yyyy-mm-dd hh24:mi:ss') INM_SYNC_TIME FROM CI_HOST_COMPARE r WHERE r.INM_CHECK_STATUS = 1 ");
        if (name != null && !"".equals(name.trim()))
            rows.append("AND r.NAME LIKE '%").append(name.trim()).append("%' ");
        if (compareStatus != null && !"-1".equals(compareStatus))
            rows.append("AND r.INM_COMPARE_STATE = ").append(compareStatus).append(" ");
        if (startTime != null && !"".equals(startTime))
            rows.append("AND r.INM_SYNC_TIME >= TO_DATE('").append(startTime).append("','yyyy-mm-dd hh24:mi:ss') ");
        if (endTime != null && !"".equals(endTime))
            rows.append("AND r.INM_SYNC_TIME <= TO_DATE('").append(endTime).append("','yyyy-mm-dd hh24:mi:ss') ");
        String field = "name".equals(sort) ? "r.NAME " : "r.INM_SYNC_TIME ";
        rows.append(" ORDER BY ").append(field).append(order).append(",r.ID desc ");
        Map<String, Object> map = new HashMap<>();
        String pagingSql = SecurityUtils.pagingQuerySql(rows.toString(), offset, limit);
        LOGGER.debug("加载同步主机表界面的表格数据_分页查询SQL:{}", pagingSql);
        List<HostCompareModel> pagingList = queryHostCompareBySql(pagingSql);
        map.put(SecurityUtils.TABLE_ROWS, pagingList);
        String countSql = SecurityUtils.countQuerySql(rows.toString());
        LOGGER.debug("加载同步主机表界面的表格数据_查询总数SQL:{}", countSql);
        map.put(SecurityUtils.TABLE_TOTAL, jdbcTemplate.queryForObject(countSql, Integer.class));
        return map;
	}
	
	// 通过sql查询并转换为HostCompareModel对象
    private List<HostCompareModel> queryHostCompareBySql(final String sql) {
        // jkd8支持的lambda表达式
        return jdbcTemplate.query(sql, (rs, i) -> {
            HostCompareModel host = new HostCompareModel();
            host.setId(SecurityUtils.convertObj2Long(rs.getObject("ID")));
            host.setName(rs.getString("NAME"));
            host.setHostName(rs.getString("HOST_NAME"));
            host.setManageIp(rs.getString("MANAGE_IP"));
            host.setCpuFamily(rs.getString("CPU_FAMILY"));
            host.setOperateSystem(rs.getString("OPERATE_SYSTEM"));
            host.setOsVersion(rs.getString("OS_VERSION"));
            host.setSerialNumber(rs.getString("SERIAL_NUMBER"));
            host.setManufacturerText(rs.getString("MANUFACTURER_TEXT"));
            host.setPhysicalCpus(SecurityUtils.convertObj2Integer(rs.getObject("PHYSICAL_CPUS")));
            host.setMemorySize(SecurityUtils.convertObj2Long(rs.getObject("MEMORY_SIZE")));
            host.setDiskCount(SecurityUtils.convertObj2Integer(rs.getObject("DISK_COUNT")));
            host.setTotalDiskSize(SecurityUtils.convertObj2Long(rs.getObject("TOTAL_DISK_SIZE")));
            host.setHostId(SecurityUtils.convertObj2Long(rs.getObject("HOST_ID")));
            host.setInmCompareStatus(SecurityUtils.convertObj2Integer(rs.getObject("INM_COMPARE_STATE")));
            host.setInmSyncTime(rs.getString("INM_SYNC_TIME"));
            return host;
        });
    }
}
