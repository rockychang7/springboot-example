package com.mamba.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringBootExampleAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleAopApplication.class, args);
	}

}
