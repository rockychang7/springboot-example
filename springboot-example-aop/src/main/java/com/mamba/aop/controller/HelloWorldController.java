package com.mamba.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/8/23 18:01
 * @description HelloWorld demo
 */

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        return "Hello World";
    }

}