package com.mamba.springboot.rabbitmq.config;

import com.mamba.springboot.rabbitmq.message.MsgReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * RabbitMq相关配置类，包括RabbitMq的模板类创建以及队列和交换机的创建
 */
@Slf4j
@Configuration
@EnableRabbit
public class RabbitMqConfig {

    //queue config
    @Bean
    public Queue directQueue() {
        Map<String, Object> args = new HashMap<>();
        //设置消息过期时间为1秒
        args.put("x-message-ttl", 5000);
        return new Queue("direct.queue", true, false, false, args);
    }

    //exchange config
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }


    @Bean
    public Binding bindDirectQueue() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct.queue");
    }

    /**
     * 创建rabbitmq操作的模板类
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("=====correlationData======" + correlationData.getReturnedMessage());
            System.out.println("=====ack======" + ack);
            System.out.println("=====cause======" + cause);
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    //消费端消息转换
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }
}
