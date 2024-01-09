package com.mamba.webflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/8 15:25
 */
@RestController
public class HelloController {

        @RequestMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello world");
    }
}