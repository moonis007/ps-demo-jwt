package com.moonis.demo.restapi.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class PSDashboardThreadConfig {
	
	@Bean
	@Primary
    public TaskExecutor threadPoolTaskExecutor() {
 
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("ps_task_executor_thread");
        executor.initialize();
        return executor;
    }

}
