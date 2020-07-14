package com.mamba.springboot.rabbitmq.service;

import com.mamba.springboot.rabbitmq.bean.Message;
import com.mamba.springboot.rabbitmq.message.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模拟消息发送的业务代码
 */
@Service
public class RabbitMqServiceImp implements RabbitMqService {


    private MsgSender msgSender;

    @Autowired
    public void setMsgSender(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    @Override
    public void sendDirectQueue(Message message) {
        msgSender.sendMsg(message, "directExchange", "direct.queue");
    }
}
