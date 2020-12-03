package com.mamba.apollo.listener;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.mamba.apollo.model.DataSourceBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Slf4j
@Component
public class ApolloConfigListener implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ApolloConfigChangeListener("TEST1.database")
    public void onChange(ConfigChangeEvent changeEvent) {
        log.info("Refreshing datasource properties!");
        Set<String> keys = changeEvent.changedKeys();
        System.out.println("change keys ==="+keys.toString());
        applicationContext.publishEvent(new EnvironmentChangeEvent(keys));
        log.info("datasource properties refreshed!");
    }
}
