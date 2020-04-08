package com.dyn.basepro.frame.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@description: 健康检查，增加自定义属性
 *@author: dyn
 *@create: 2020-03-30 21:19
 */
@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Value("${server.servlet.context-path:}")
    private String contextPath;
    @Value("${server.profiles.active:}")
    private String currentEnv;
    @Value("${server.application.name:}")
    private String applicationName;

    @Override
    protected void doHealthCheck(Health.Builder builder)throws Exception{
        builder.up().withDetail("applicationName",applicationName);
        builder.up().withDetail("currentTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        builder.up().withDetail("currentEnv",currentEnv);
        builder.up().withDetail("contextPath",contextPath);
    }
}
