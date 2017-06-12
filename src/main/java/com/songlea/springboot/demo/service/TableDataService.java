package com.songlea.springboot.demo.service;

import java.util.Map;

/**
 * 数据Service接口层
 * 
 * @author Song Lea
 */
public interface TableDataService {
	
	// 获取table表格数据
	Map<String, Object> queryTableData(String name, String compareStatus, String startTime, 
			String endTime, int limit, int offset, String sort, String order);
	
}
