package com.mamba.externalizedconfiguration;

import com.mamba.externalizedconfiguration.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringBootExampleExternalizedConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleExternalizedConfigurationApplication.class, args);

    }


}
