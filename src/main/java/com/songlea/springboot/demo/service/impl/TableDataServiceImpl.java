package com.songlea.springboot.demo.service.impl;

import java.util.Map;

import com.songlea.springboot.demo.dao.TableDataDao;
import com.songlea.springboot.demo.service.TableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 数据Service层实现
 * 
 * @author Song Lea
 */
@Service
public class TableDataServiceImpl implements TableDataService {
	
	private TableDataDao tableDataDao;

    public TableDataServiceImpl() {}

    @Autowired
    public TableDataServiceImpl(TableDataDao tableDataDao) {
    	Assert.notNull(tableDataDao, "TableDataServiceImpl.tableDataDao must be not null!");
    	this.tableDataDao = tableDataDao;
    }

	@Override
	public Map<String, Object> queryTableData(String name, String compareStatus, String startTime,
			String endTime, int limit, int offset, String sort, String order) {
		return tableDataDao.queryTableData(name, compareStatus, startTime, endTime, 
				limit, offset, sort, order);
	}

}
