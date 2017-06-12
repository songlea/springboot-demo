package com.songlea.springboot.demo.configure.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 场景-拦截器注册
 * WebMvcConfigurerAdapter:这个类的作用是进行SpringMVC的一些配置
 *
 * @author Song Lea
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // 自实现的SpringMVC拦截器
    private SpringMvcInterceptor springMvcInterceptor;

    public WebMvcConfig() {
    }

    @Autowired
    // 需要在该拦截器上添加@Configuration注解才能注入
    // 构造器注入,会进行springMvcInterceptor非空检查,防止空指针异常
    public WebMvcConfig(SpringMvcInterceptor springMvcInterceptor) {
        Assert.notNull(springMvcInterceptor, "WebMvcConfig.springMvcInterceptor must not be null!");
        this.springMvcInterceptor = springMvcInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springMvcInterceptor)
                .addPathPatterns("/table/*") // 要拦截的请求
                .excludePathPatterns("/jsp/*", "/groovy/*", "/druid/*", "/freemarker/*", "/thymeleaf/*"); // 不拦截的请求
        // 注册spring boot的默认拦截器
        super.addInterceptors(registry);
    }

}
