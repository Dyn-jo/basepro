package com.dyn.basepro.config.apollo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 *@description: ApolloConfig
 *@author: dyn
 *@create: 2020-03-30 21:00
 */
@Data
@Configuration
@RefreshScope
public class ApolloConfig {

    @Value("${server.port:}")
    String serverPort;

    @Value("${server.servlet.context-path:}")
    String contextPath;

    @Value("${spring.application.name:}")
    String applicationName;

    @Value("${spring.profiles.active:}")
    String profilesActive;

    @Value("${spring.redis.host:}")
    String redisHost;

    @Value("${spring.redis.password:}")
    String redisPassword;

    @Value("${spring.redis.database:}")
    String redisDatabase;

    @Value("${spring.redis.port:}")
    String redisPort;

    @Value("${spring.redis.timeout:}")
    String redisTimeout;

    @Value("${spring.sleuth.sampler.probability:}")
    String samplerProbability;

    @Value("${spring.zipkin.base-url:}")
    String zipkinBaseUrl;

    @Value("${eureka.client.service-url.defaultZone:}")
    String eurekaDefaultZone;

}
