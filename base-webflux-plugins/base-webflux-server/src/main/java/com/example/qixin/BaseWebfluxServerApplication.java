package com.example.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/** 一、mongo查询 https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/

 */
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class BaseWebfluxServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(BaseWebfluxServerApplication.class, args);
	}

	@EnableAsync
	@Configuration
	class TaskPoolConfig {
		@Bean("taskExecutor")
		public Executor taskExecutor() {
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(10); //核心线程数10
			executor.setMaxPoolSize(20); //最大线程数20
			executor.setQueueCapacity(200); //缓冲队列200
			executor.setKeepAliveSeconds(60);//允许线程的空闲时间60秒
			executor.setThreadNamePrefix("taskExecutor-");//线程池名的前缀
			RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
			executor.setRejectedExecutionHandler(handler);//线程池对拒绝任务的处理策略

			//ThreadPoolTaskScheduler线程池的优雅关闭
			executor.setWaitForTasksToCompleteOnShutdown(true);
			executor.setAwaitTerminationSeconds(60);
			return executor;
		}
	}
}

