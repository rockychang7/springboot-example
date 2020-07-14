package com.mamba.springboot.rabbitmq.service;

import com.mamba.springboot.rabbitmq.bean.Message;

public interface RabbitMqService {

    void sendDirectQueue(Message message);
}
