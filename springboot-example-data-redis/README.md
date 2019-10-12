## SpringBoot整合Redis
SpringBoot支持redis的自动注入，SpringBoot同时提供对Jedis和Lettuce两种客户端的工具（默认使用Lettuce，自动加入它的依赖）

## 依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

```

## 环境
首先需要在本地或者服务器上安装Redis服务器，安装教程参见官网 [传送门](https://redis.io/download)

## 配置
在加入相关依赖后，需要对redis的连接参数进行配置，当然还有一些可选参数可供选择
```
spring.redis.host=192.168.25.129
spring.redis.password=mamba@popidea
```


## 操作
具体操作可以参见[RedisBootStrap](./src/main/java/com/mamba/redis/RedisBootstrap.java),主要针对Redis几种参见数据类型进行了操作

## 扩展
Redis的具体语法参见[传送门](https://redis.io/documentation)