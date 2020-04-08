package com.dyn.basepro.frame.apollo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 *@description: apollo配置中心自动刷新
 *@author: dyn
 *@create: 2020-03-30 21:01
 */
@Component
public class ApolloRefresh implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private RefreshScope refreshScope;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ApolloConfigChangeListener
    public void refresh(ConfigChangeEvent event) {
        Set<String> changedKeys = event.changedKeys();
        if (changedKeys != null && changedKeys.size() != 0) {
            this.applicationContext.publishEvent(new EnvironmentChangeEvent(changedKeys));
            this.refreshScope.refreshAll();
        }

    }

}
