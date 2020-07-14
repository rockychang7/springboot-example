package com.mamba.springboot.rabbitmq.message;
import com.mamba.springboot.rabbitmq.bean.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * 消息接收监听类
 *
 * @RabbitListener 用来接收指定的队列的消息
 */
@Configuration
@RabbitListener(queues = "direct.queue", containerFactory = "rabbitListenerContainerFactory")
public class MsgReceiver {

    @RabbitHandler(isDefault = true)
    public void receiveDirectMsg(Message message) {
        System.out.println("====received msg:======" + message.getMsg());
    }

    @RabbitHandler(isDefault = true)
    public void receiveDirectMsg(String message) {
        System.out.println("====received msg:======" + message);
    }
}
