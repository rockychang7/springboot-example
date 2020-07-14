package com.mamba.springboot.rabbitmq.message;

import com.mamba.springboot.rabbitmq.bean.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送类
 */
@Component
public class MsgSender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMsg(Message message, String exchange, String queue) {
        rabbitTemplate.convertAndSend(exchange, queue, message);
    }

}
