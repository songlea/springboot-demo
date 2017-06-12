# springboot-demo
Spring Boot的demo,包含了druid连接池，Mybatis集成，thymeleaf，freemarker，groovy，jsp等模板配置等

# 配置说明

1. 项目配置文件
application.properties(或application.yaml),启动后会加载该配置文件,在java类中可以通过@Value注解来获取对应属性值。常见配置包括(具体见demo工程中application.properties)：  
a、server配置  
b、cookie,session配置  
c、activemq配置  
d、multipart and http配置  
e、view配置  
f、resource配置  
g、内置的tomcat和jetty配置  
h、datasource配置  
i、各种模板配置,如freemarker,thymeleaf,groovy与jsp等  
j、其他自定义属性  
k、…  
  
2. 数据库连接池配置  
Spring Boot官方未集成druid连接池，需要手动配置并注入DataSource。  
a、在application.properties中配置连接池属性:  
  spring.datasource.xxx开头的配置  
b、 通过@Configuration 与@Bean注解将DataSource注入:  
  详见demo工程中com.songlea.springboot.demo.configure.DruidDBConfig类
  
3. 自定义Servlet、Filter、Listener配置  
在spring boot中添加自己的Servlet、Filter和Listener有两种方法,代码注册和注解自动注册：  
a、代码注册通过ServletRegistrationBean、FilterRegistrationBean 和 ServletListenerRegistrationBean 获得控制，
可以通过实现 ServletContextInitializer 接口直接注册(示例见下面cas配置)。  
b、在 @SpringBootApplicationy启动类上使用@ServletComponentScan 注解后，
Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。  
使用注解配置步骤(demo工程):  
a、 在启动类DemoApplication中   
//扫描WebServlet,WebFilter,WebListener注解,只有使用servlet容器时作用  
@ServletComponentScan(value = {"com.songlea.springboot.demo.servlet"})  
b、 com.songlea.springboot.demo.servlet 包下Servlet，Filter与监听器(详见代码)  
    
4. 集成cas(单点登录)配置  
配置步骤(demo工程并通过代码注册的方式配置Filter与Listener):  
a、在application.properties中配置cas服务端地址与应用的地址  
  cas.param.xxx开头的配置  
b、com.songlea.springboot.demo.configure.cas下CasFilterConfig与CasListenerConfig(详见代码)  

5. 代码中获取非application.properties文件中的属性值  
配置步骤(demo工程)：  
a、在pom.xml中加入spring-boot-configuration-processor依赖  
b、见com.songlea.springboot.demo.configure.OtherFileConfig：  
  @Component // 注入bean  
  // 新版本ConfigurationProperties取消了locations,使用PropertySource代替  
  @PropertySource("classpath:other-config-file.properties")  
  @ConfigurationProperties(prefix = "other.config")  
c、使用见com.songlea.springboot.demo.controller.FreeMarkerHomeController类,使用@Autowired注入并通过get方法获取属性值  

6. 定时任务配置  
工程可能需要后台定时执行某些任务，Spring Boot提供支持频率与cron表达式的调度策略。  
配置步骤(demo工程)：  
com.songlea.springboot.demo.configure.SchedulingConfig类  

7. Spring MVC拦截器  
配置(demo工程)：  
a、自定义拦截器配置类:详见com.songlea.springboot.demo.configure.interceptor.SpringMvcInterceptor类  
b、添加自实现的拦截器:详见com.songlea.springboot.demo.configure.interceptor.WebMvcConfig类  

8. jsp模板配置  
Spring Boot默认已经不再支持jsp视图展示(不推荐),要支持jsp需要做一下工作:  
com.songlea.springboot.demo.controller.JSPHomeController  
配置步骤(demo工程)  
a、application.yml中配置(这里也可以是properties配置文件)：  
 	spring.mvc.view.prefix=/WEB-INF/views/  
 	spring.mvc.view.suffix=.jsp  
b、pom.xml修改为打成war包  
  &lt;packaging&gt;war&lt;/packaging&gt;  
c、需要改变启动类  
	 继承extends SpringBootServletInitializer  
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
		  return application.sources(DemoApplication.class);  
	}  
d、引入jsp解析及jstl依赖(scope设置为provided,在测试与打包编译时需要,在war包中不包含),在pom.xml  
  &lt;dependency&gt;  
    &nbsp;&nbsp;&lt;groupId&gt;org.apache.tomcat.embed&lt;/groupId&gt;  
    &nbsp;&nbsp;&lt;artifactId&gt;tomcat-embed-jasper&lt;/artifactId&gt;  
    &nbsp;&nbsp;&lt;scope&gt;provided&lt;/scope&gt;  
  &lt;/dependency&gt;  
  &lt;dependency&gt;  
    &nbsp;&nbsp;&lt;groupId&gt;javax.servlet&lt;/groupId&gt;  
    &nbsp;&nbsp;&lt;artifactId&gt;jstl&lt;/artifactId&gt;  
    &nbsp;&nbsp;&lt;scope&gt;provided&lt;/scope&gt;  
  &lt;/dependency&gt;  
  &lt;dependency&gt;  
    &nbsp;&nbsp;&lt;groupId&gt;javax.servlet&lt;/groupId&gt;  
    &nbsp;&nbsp;&lt;artifactId&gt;javax.servlet-api&lt;/artifactId&gt;  
    &nbsp;&nbsp;&lt;scope&gt;provided&lt;/scope&gt;  
  &lt;/dependency&gt;  
e、添加webapp及下WEB-INF目录  
f、使用mvn install打包(skip tests)  

9. 其他模板配置  
demo工程中包含FreeMarker、Groovy、Thymeleaf模板的使用,以freemarker为例：  
a、在pom.xml中加入依赖  
  &lt;dependency&gt;  
	   &nbsp;&nbsp;&lt;groupId&gt;org.springframework.boot</groupId&gt;  
	   &nbsp;&nbsp;&lt;artifactId&gt;spring-boot-starter-freemarker&lt;/artifactId&gt;  
  &lt;/dependency&gt;  
b、application.properties配置(启用freemarker并注释掉其他的模板配置)  
  spring.freemarker.xxx 开头  
c、视图层位于:/resources/static/templates/freemarker.ftl  
d、控制层：com.songlea.springboot.demo.controller.FreeMarkerHomeController类  

10. 集成Mybatis  
如使用jdbcTemplate添加spring-boot-starter-jdbc依赖,使用hibernate添加spring-boot-starter-data-jpa依赖(包含jdbc)  
jpa使用方法参考：https://spring.io/guides/gs/accessing-data-jpa/  
以下为Spring Boot集成Mybatis配置步骤(demo工程,Mybatis集成测试时界面需要引入demo2.js，而demo.js请求后台使用的是jdbcTemplate)：  
a、在pom.xml中加入mybatis与分页插件支持  
  &lt;!--mybatis支持与分页插件--&gt;与&lt;!--page helper--&gt;两个依赖  
b、application.properties中配置mybatis与pageHelper的属性  
  mybatis.xxx与pagehelper.xxx开头  
c、编写mapper接口与mapper.xml配置文件  
  resources/mapper/HostCompareModelMapper.xml  
  com.songlea.springboot.demo.mapper.HostCompareModelMapper类  
d、Controller层  
  com.songlea.springboot.demo.controller.TableDataController类通过@Autowired注入Mapper并调用其方法  
   @RequestMapping(value = "/queryMybatisTableData") 请求
  
