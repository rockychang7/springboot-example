package com.mamba.springboot.rabbitmq.controller;

import com.mamba.springboot.rabbitmq.bean.Message;
import com.mamba.springboot.rabbitmq.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟发送消息
 */
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PostMapping(value = "/directMsg")
    public Message sendDirectMsg() {
        Message message = new Message();
        message.setMsg("hello world");
        rabbitMqService.sendDirectQueue(message);
        return message;
    }

}
