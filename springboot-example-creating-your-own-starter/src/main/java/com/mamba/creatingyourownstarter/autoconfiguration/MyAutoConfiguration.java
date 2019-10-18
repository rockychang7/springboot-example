package com.mamba.creatingyourownstarter.autoconfiguration;

import com.mamba.creatingyourownstarter.service.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/18 18:08
 * @description
 */

@Configuration
@ConditionalOnProperty(prefix = "my", name = "auth", havingValue = "true")
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyService myService() {
        return new MyService();
    }

}