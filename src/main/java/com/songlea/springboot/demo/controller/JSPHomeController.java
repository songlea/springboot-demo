package com.songlea.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 场景-使用jsp模板
 *
 * Spring Boot默认已经不再支持jsp视图展示,要支持jsp需要做一下工作:
 * 1、application.yml中配置(这里也可以是properties配置文件)：
 *      spring.mvc.view.prefix=/WEB-INF/views/
 *      spring.mvc.view.suffix=.jsp
 * 2、引入jsp解析及jstl依赖(scope设置为provided),pom.xml
 *      <dependency>
 *          <groupId>org.apache.tomcat.embed</groupId>
 *          <artifactId>tomcat-embed-jasper</artifactId>
 *          <scope>provided</scope>
 *      </dependency>
 *      <dependency>
 *          <groupId>javax.servlet</groupId>
 *          <artifactId>jstl</artifactId>
 *          <scope>provided</scope>
 *      </dependency>
 *      <dependency>
 *          <groupId>javax.servlet</groupId>
 *          <artifactId>javax.servlet-api</artifactId>
 *          <scope>provided</scope>
 *      </dependency>
 * 3、配置maven项目打包方式为war包,不要使用main方法启动应用
 *      pom.xml中配置<packaging>war</packaging>
 * 4、需要改变启动类
 *       继承extends SpringBootServletInitializer
 *
 * @author Song Lea
 */
@Controller
@RequestMapping("/jsp")
public class JSPHomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "jsp";
    }
}
