package com.songlea.springboot.demo.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 场景-定时任务配置
 *
 * @author Song Lea
 */
@Configuration
// 作用是发现注解@Scheduled的任务并后台执行,本身默认的执行方式是串行执行,多个tasks时都是一个线程串行执行;
// 以下继承SchedulingConfigurer并重实现configureTasks可以实现多个任务并行执行,但其中的每个任务依然串行
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingConfig.class);
	
	// 自定义任务调度配置
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
	}

	@Bean(destroyMethod = "shutdown")
	public ScheduledExecutorService taskExecutor() {
		return Executors.newScheduledThreadPool(10);
	}

	// cron：支持cron表达式,指定任务在特定时间执行(如下cron = "0 0 1 * * ?"表示每天凌晨1点执行);
	// fixedRate:以特定频率(毫秒)执行任务(如下fixedDelay = 60000表示1分钟执行一次);
	// fixedRateString以string的形式配置执行频率。
	// @Scheduled(cron = "0 0 1 * * ?")
	@Scheduled(fixedDelay = 60000)
	public void scheduledDemo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOGGER.info("任务执行当前时间:" + format.format(new Date()));
	}
}
