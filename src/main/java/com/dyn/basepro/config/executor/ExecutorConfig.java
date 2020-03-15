package com.dyn.basepro.config.executor;

import com.dyn.basepro.properties.ThreadPoolProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *@description: 线程池
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
@Configuration
public class ExecutorConfig {

    @Autowired
    ThreadPoolProp threadPoolProp;

    @Bean

    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolProp.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolProp.getMaxPoolSize());
        executor.setKeepAliveSeconds(300);
        executor.setQueueCapacity(threadPoolProp.getMaxPoolSize() * 10);
        executor.setThreadNamePrefix("BaseExecutor-");
        return executor;
    }

}
