 package com.songlea.springboot.demo.configure.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 场景-spring mvc拦截器 
 * 
 * spring boot拦截器默认有:
 * HandlerInterceptorAdapter:适配器，继承此类可以非常方便的实现自己的拦截器
 * AbstractHandlerMapping:提供了抽象方法getHandlerInternal在子类中实现,根据获得的Handler及配置的拦截器Interceptor来生成HandlerExecutionChain 
 * UserRoleAuthorizationInterceptor:继承抽象类HandlerInterceptorAdapter,实现了用户登录认证的拦截功能,如果当前用户没有通过认证,会报403错误 
 * LocaleChangeInterceptor:国际化操作拦截器 
 * ThemeChangeInterceptor:如果需要根据用户请求来改变主题,则需要使用ThemeChangeInterceptor拦截器
 * 
 * @author Song Lea
 */
@Configuration
public class SpringMvcInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringMvcInterceptor.class);
	
	@Override
	// 只有返回true才会继续向下执行，返回false则取消当前请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		LOGGER.info("在请求处理之前进行调用(Controller方法调用之前)！");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	LOGGER.info("请求处理之后进行调用，但是在视图被渲染之前(Controller方法调用之后)！");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    	LOGGER.info("在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行(主要是用于进行资源清理工作)！");
    }
}
