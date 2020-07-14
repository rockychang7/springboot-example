## SpringBoot整合RabbitMq

### 1. 依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### 2. 演示
本demo使用Direct类型的交换机进行消息绑定，此种类型可以根据route key匹配queue和exchange之间的关系。

### 3. Exchange
常用类型
- Fanout:没有具体的匹配，属于广播形式
- Direct:可以根据route key进行queue和exchange的绑定
- Topic：和Direct类似不过可以通过表达式进行模糊匹配，一个exchange可以匹配部分的Queue

### 4 几个重要的注解
- @EnableRabbit :开启注解方式使用RabbitMq(SpringBoot默认就会开启)
- @RabbitListener:监听消息信息，可以作用于方法或者类
- @RabbitHandler:监听到消息后标注的处理方法，这个注解作用于方法

### 4.教程
[传送门](https://www.rabbitmq.com/getstarted.html)