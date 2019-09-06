package com.mamba.argument.application_arguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/6 15:32
 * @description 展示如何通过ApplicationArguments来获取命令行参数
 */
@Component
public class ApplicationArgumentsDemoImpl implements ApplicationArgumentsDemo {

    @Autowired
    public ApplicationArgumentsDemoImpl(ApplicationArguments args) {
        System.out.println("debug============" + args.containsOption("debug"));
        System.out.println("非选项性参数======" + args.getNonOptionArgs());
    }
}