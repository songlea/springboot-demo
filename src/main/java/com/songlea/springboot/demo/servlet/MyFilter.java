package com.songlea.springboot.demo.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 场景-自定义过滤器(使用注解标注过滤器)
 * 注：需要在启动类上使用@ServletComponentScan注解后生效(DemoApplication)
 * 
 * @author Song Lea
 */
// 属性filterName声明过滤器的名称,可选
// 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
@WebFilter(filterName="selfDefinedFilter", urlPatterns="/*")
public class MyFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public void destroy() {
		LOGGER.info("自定义过滤器销毁！");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain)
	throws IOException, ServletException {
		LOGGER.info("自定义过滤器执行内容：" + request.getServletContext().getSessionCookieConfig());
		// 作用是将请求转发给过滤器链上下一个对象，指的是下一个filter，如果没有filter那就是你请求的资源。
		chain.doFilter(request, reponse);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("自定义过滤器初始化！");
	}
}
