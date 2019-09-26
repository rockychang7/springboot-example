## SpringBoot整合freemarker的模板引擎
SpringBoot支持freemarker的自动装配，需要导入相关依赖就行。

## 依赖
``` 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

## 配置
springboot支持配置文件对freemarker属性进行配置，样例如下
```
spring.freemarker.charset=UTF-8
spring.freemarker.suffix=.ftl
spring.freemarker.cache=false
```

## demo运行
1. `http://localhost:8080`进入登录界面
![uAsdNd.png](https://s2.ax1x.com/2019/09/24/uAsdNd.png)

2.  点击登录进入首页，通过thymeleaf引擎来显示用户数据
![uAs53q.png](https://s2.ax1x.com/2019/09/24/uAs53q.png)

## freemarker扩展
freemarker具体语法参见[https://freemarker.apache.org/docs/index.html](https://freemarker.apache.org/docs/index.html)