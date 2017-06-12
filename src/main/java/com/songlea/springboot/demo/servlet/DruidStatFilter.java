package com.songlea.springboot.demo.servlet;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Druid数据库连接池的过滤器
 *
 * @author Song Lea
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
	// 忽略的资源后缀名
	@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}
)
public class DruidStatFilter extends WebStatFilter {

    /* 相当于在web.xml中的如下配置:
    <filter>
          <filter-name>druidWebStatFilter</filter-name>
          <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
          <init-param>
              <param-name>exclusions</param-name>
              <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
          </init-param>
      </filter>
      <filter-mapping>
          <filter-name>druidWebStatFilter</filter-name>
          <url-pattern>/*</url-pattern>
      </filter-mapping>
     */
}
