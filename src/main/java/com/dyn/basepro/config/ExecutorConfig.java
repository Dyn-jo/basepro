package  com.dyn.basepro.config;

import  com.dyn.basepro.properties.ThreadPoolProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *
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
