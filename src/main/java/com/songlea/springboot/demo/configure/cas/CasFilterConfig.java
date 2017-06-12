package com.songlea.springboot.demo.configure.cas;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cas配置注册bean
 *
 * @author Song Lea
 */
@Configuration
public class CasFilterConfig {
	
    @Value("${cas.param.serverName}")
    private String serverName;

    @Value("${cas.param.casServerLoginUrl}")
    private String casServerLoginUrl;

    @Value("${cas.param.authFilterName}")
    private String authFilterName;

    @Value("${cas.param.casServerUrlPrefix}")
    private String casServerUrlPrefix;

    @Value("${cas.param.casFilterName}")
    private String casFilterName;

    // 这个Filter的职责只是判断是否已经登录,如果没有登录,则根据配置（gateway）来决定条状到什么地方
    @Bean
    public FilterRegistrationBean authenticationFilterRegistrationBean() {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        // 如果为true则每次请求都产生新的session,默认是false,可选参数
        authenticationFilter.setRenew(false);
        // 指定是否使用防火墙,有效值是true和false,默认是false,可选参数
        authenticationFilter.setGateway(false);
        // artifactParameterName - 指定request保存票据的参数名称，默认是ticket
        // serviceParameterName - 指定request保存service的参数名称，默认是service
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // CAS客户端的服务器名称,Service URL使用这个名称动态组装,必要参数
        registration.addInitParameter("serverName", serverName);
        // 定义CAS服务器的登录URL地址,必要参数
        registration.addInitParameter("casServerLoginUrl", casServerLoginUrl);
        registration.setName(authFilterName);
        registration.addUrlPatterns("/*");
        registration.setFilter(authenticationFilter);
        return registration;
    }

    // 继承AbstractTicketValidationFilter,用于验证ticket
    // 模板方法如getTicketValidator，preFilter，onSuccessfulValidation，onFailedValidation等
    @Bean
    public FilterRegistrationBean ticketValidationFilterRegistrationBean() {
        Cas20ProxyReceivingTicketValidationFilter ticketValidation = new Cas20ProxyReceivingTicketValidationFilter();
        ticketValidation.setUseSession(true);
        ticketValidation.setRedirectAfterValidation(true);
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
        registration.addInitParameter("serverName", serverName);
        registration.addUrlPatterns("/*");
        registration.setName(casFilterName);
        registration.setFilter(ticketValidation);
        return registration;
    }

    // 就是在HttpServletRequest对象再包装一次,让其支持getUserPrincipal、getRemoteUser方法来取得登录的用户信息
    @Bean
    public FilterRegistrationBean wrapperFilterRegistrationBean() {
        HttpServletRequestWrapperFilter wrapperFilter = new HttpServletRequestWrapperFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setName("CAS HttpServletRequest Wrapper Filter");
        registration.setFilter(wrapperFilter);
        return registration;
    }

    // 就是将Assertion绑定到ThreadLocal,里面的AssertionHolder类持有一个ThreadLocal<Assertion>对象
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        AssertionThreadLocalFilter assertionThreadLocalFilter = new AssertionThreadLocalFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setName("CAS Assertion Thread Local Filter");
        registration.setFilter(assertionThreadLocalFilter);
        return registration;
    }
}
