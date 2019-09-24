## SpringBoot整合thymeleaf模板引擎
SpringBoot支持thymeleaf的自动装配，因此只需加入如下配置就可使用:


### 依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### 配置
springboot默认为thymeleaf提供了很多的属性来指定义相关配置,实例如下
```
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.mode=HTML
spring.thymeleaf.prefix=classpath:/templates/
```

### demo运行
1. `http://localhost:8080`进入登录界面
![uAsdNd.png](https://s2.ax1x.com/2019/09/24/uAsdNd.png)

2.  点击登录进入首页，通过thymeleaf引擎来显示用户数据
![uAs53q.png](https://s2.ax1x.com/2019/09/24/uAs53q.png)

### thymeleaf扩展
具体语法参见  [https://www.thymeleaf.org/documentation.html](https://www.thymeleaf.org/documentation.html)