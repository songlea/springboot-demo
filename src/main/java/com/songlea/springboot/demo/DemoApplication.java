package com.songlea.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  Spring Boot项目生成网址:https://start.spring.io/
 */
// 相关于使用@Configuration,@EnableAutoConfiguration与@ComponentScan的默认属性
@SpringBootApplication
// @EnableAutoConfiguration:尝试根据你添加的jar依赖自动配置你的Spring应用
// 扫描WebServlet,WebFilter,WebListener注解,只有使用servlet容器时作用
@ServletComponentScan(value = {"com.songlea.springboot.demo.servlet"})
// 启注解事务管理,等同于xml配置方式的<tx:annotation-driven />,可以使用@Transactional注解
@EnableTransactionManagement
@MapperScan(basePackages = "com.songlea.springboot.demo.mapper")
public class DemoApplication  /* extends SpringBootServletInitializer */ {

	/* 使用jsp模板时需要extends SpringBootServletInitializer并且继承这个方法 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
