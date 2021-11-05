package com.mamba.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
@EnableOpenApi
@SpringBootApplication
public class SpringbootExampleSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExampleSwagger2Application.class, args);
    }

}
