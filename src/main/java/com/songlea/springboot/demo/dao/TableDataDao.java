package com.songlea.springboot.demo.dao;

import java.util.Map;

/**
 * 数据Dao层接口
 * 
 * @author Song Lea
 */
public interface TableDataDao {
	
	// 获取table表格数据
	Map<String, Object> queryTableData(String name, String compareStatus, String startTime, 
			String endTime, int limit, int offset, String sort, String order);
	
}
