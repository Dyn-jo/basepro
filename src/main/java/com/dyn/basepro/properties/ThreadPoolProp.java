package com.dyn.basepro.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *@description: 线程池prop
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
@Configuration
@Data
@PropertySource(value = "classpath:config/common.properties")
public class ThreadPoolProp {

    @Value("${spring.executor.corePoolSize}")
    private Integer corePoolSize;

    @Value("${spring.executor.maxPoolSize}")
    private Integer maxPoolSize;

}
