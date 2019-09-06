package com.mamba.argument.command_line_runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/6 15:46
 * @description 实现CommandLineRunner接口，在SpringApplication完成run方法之前完成特定操作
 */
@Component
public class CommandLineRunnerDemo implements CommandLineRunner, Ordered {

    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            if (arg.equals("--debug")) {
                System.out.println("本应用是以debug方式启动的(CommandLineRunner)。。。");
            }
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}