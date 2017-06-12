package com.songlea.springboot.demo.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 场景-自定义监听器(使用注解标注)
 * 
 * 监听器类应该实现下面接口之一：
 * 1.对Request的监听有ServletRequestListener和ServletRequestAttributeListener;
 * 前者可见监听Request的创建和销毁；而后者可以对Request的属性进行监听。
 * 
 * 2.对Session的监听有HttpSessionListener和HttpSessionAttributeListener;
 * 前者可以监听HttpSession的创建跟销毁，后者则是对session中属性的监听，它可以监听到session新增属性、移除属性和属性值被替换时。
 * 
 * 3.对于ServletContext的监听器有ServletContextListener和ServletContextAttributeListener;
 * 前者可以监听到ServletContext的创建和销毁，而后者可以监听到ServletContext中属性的新增、移除和属性值的替换。
 * @author Song
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LOGGER.info("ServletContext销毁！");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LOGGER.info("ServletContext初始化！");
		
	}
	
	/* 相当于在web.xml中配置：
	<listener>  
   		<listener-class>com.ustcinfo.springboot.demo.MyServletContextListener</listener-class>  
	</listener> 
	*/
}
