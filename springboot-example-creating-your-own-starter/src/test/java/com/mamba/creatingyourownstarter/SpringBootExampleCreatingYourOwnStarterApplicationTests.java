package com.mamba.creatingyourownstarter;

import com.mamba.creatingyourownstarter.autoconfiguration.MyAutoConfiguration;
import com.mamba.creatingyourownstarter.service.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class SpringBootExampleCreatingYourOwnStarterApplicationTests {


    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(MyAutoConfiguration.class));

    @Test
    void contextLoads() {
    }


    @Configuration
    static class MyConfiguration {
        @Bean
        public MyService myService() {
            return new MyService();
        }
    }
}
