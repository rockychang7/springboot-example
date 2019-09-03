package com.mamba.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleDevtoolsApplication {

    public static void main(String[] args) {
        //禁止devtools自动重启
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SpringBootExampleDevtoolsApplication.class, args);
    }

}
