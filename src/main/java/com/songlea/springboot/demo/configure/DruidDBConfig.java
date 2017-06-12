package com.songlea.springboot.demo.configure;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 场景-数据库连接池配置
 *
 * @author Song Lea
 */
@Configuration
// SpringBoot官方非集成druid连接池,故需要手动配置
public class DruidDBConfig {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidDBConfig.class);

    // 获取配置文件的值,即使给变量赋了初值也会以配置文件的值为准,当值为null时可以设置默认值
    // ${ property : default_value } 或 #{ obj.property? : default_value }
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean
    @Primary  // 表示当有多个DataSource时,此DataSource为主bean,首先使用
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            LOGGER.error("druid configuration initialization filter error!", e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }

    /* 相当于SpringMVC时在xml文件中如下配置:
    <!-- 数据源 -->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
		init-method="init" destroy-method="close">
		<!-- 基本属性 url、user、password -->
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialSize" value="${jdbc.initialSize}" />
		<property name="minIdle" value="${jdbc.minIdle}" />
		<property name="maxActive" value="${jdbc.maxActive}" />
		<!-- 配置获取连接等待超时的时间 -->
		<property name="maxWait" value="${jdbc.maxWait}" />
		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<property name="timeBetweenEvictionRunsMillis" value="${jdbc.timeBetweenEvictionRunsMillis}" />
		<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		<property name="minEvictableIdleTimeMillis" value="${jdbc.minEvictableIdleTimeMillis}" />
		<!--连接的验证 -->
		<property name="validationQuery" value="${jdbc.validationQuery}" />
		<property name="testWhileIdle" value="${jdbc.testWhileIdle}" />
		<property name="testOnBorrow" value="${jdbc.testOnBorrow}" />
		<property name="testOnReturn" value="${jdbc.testOnReturn}" />
		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<property name="poolPreparedStatements" value="${jdbc.poolPreparedStatements}" />
		<property name="maxOpenPreparedStatements" value="${jdbc.maxOpenPreparedStatements}" />
		<property name="removeAbandoned" value="${jdbc.removeAbandoned}" />
		<property name="removeAbandonedTimeout" value="${jdbc.removeAbandonedTimeout}" />
		<property name="logAbandoned" value="${jdbc.logAbandoned}" />
		<!-- 配置监控统计拦截的filters -->
		<property name="filters" value="${jdbc.filtes}" />
	</bean>
     */
}
