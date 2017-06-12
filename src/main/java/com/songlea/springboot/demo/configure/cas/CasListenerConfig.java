package com.songlea.springboot.demo.configure.cas;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cas配置注册bean
 *
 * @author Song Lea
 */
@Configuration
public class CasListenerConfig {

    @Value("${cas.param.casServerLogoutUrl}")
    private String casServerLogoutUrl;

    @Value("${cas.param.logoutListenerName}")
    private String logoutListenerName;

    // 在spring boot中添加自己的Servlet有两种方法,代码注册Servlet和注解自动注册(Filter和Listener也是如此)
    // 一、代码注册通过ServletRegistrationBean、FilterRegistrationBean 和 ServletListenerRegistrationBean 获得控制，
    // 也可以通过实现 ServletContextInitializer 接口直接注册。
    // 二、在 SpringBootApplication 上使用@ServletComponentScan 注解后，
    // Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> ssoListenerRegistrationBean() {
        // SingleSignOutHttpSessionListener实现了javax.servlet.http.HttpSessionListener接口，用于监听session销毁事件
        SingleSignOutHttpSessionListener logoutListener = new SingleSignOutHttpSessionListener();
        // 通过ServletListenerRegistrationBean获取控制加入相关的监听
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> registration = new ServletListenerRegistrationBean<>();
        registration.setListener(logoutListener);
        registration.addInitParameter("casServerLogoutUrl", casServerLogoutUrl);
        registration.setName(logoutListenerName);
        registration.setEnabled(true);
        return registration;
    }
}
