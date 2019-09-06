package com.mamba.argument.application_runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/6 15:43
 * @description 实现ApplicationRunner接口，在SpringApplication完成run方法之前完成特定操作
 */
@Order(value = 2)
@Component
public class ApplicationRunnerDemo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.containsOption("debug")) {
            System.out.println("本应用是以debug方式启动的(ApplicationRunner)。。。");
        }
    }
}