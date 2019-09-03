## 什么是spring-boot-devtools
springboot提供的用来支持热加载的组件
## 作用
它是通过检测classpath下文件的变化来实现实时的监控，可以让开发中项目快速重启并且实现动态资源加载。并且devtools还支持Templates的重新加载，默认禁用了某些模板引擎的缓存功能。

> 默认情况下，对于完全打包的springboot项目会自动禁用devtools。如果是在容器中运行，需要设置-Dspring.devtools.restart.enabled=false或者排除devtools依赖来禁用此功能

## 依赖
```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
		
	
	<!-- 用来支持remote devtools的使用 -->	
	<build>
    	<plugins>
    		<plugin>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-maven-plugin</artifactId>
    			<configuration>
    				<excludeDevtools>false</excludeDevtools>
    			</configuration>
    		</plugin>
    	</plugins>
    </build>
```

## 相关配置(application.properties)
```
#  禁用devtools默认的配置项
spring.devtools.add-properties=false
#  禁用每次devtools进行重启的时候输出的日志
spring.devtools.restart.log-condition-evaluation-delta=false
#  定制不需要devtools重新启动的资源
spring.devtools.restart.exclude=static/**,public/**
#  保持devtools默认的排除不需要重新启动资源，另外增加自定义资源
spring.devtools.restart.additional-exclude=static/**
#  自定义需要检测文件变化的路径
spring.devtools.restart.additional-paths=cunstom/**
#  禁止使用自动重启(还是会初始化自动启动类，不过不会在检测文件的变化)
spring.devtools.restart.enabled=false
#  设置特定触发重启的文件
spring.devtools.restart.trigger-file=
#  禁用动态加载
spring.devtools.livereload.enabled=false

#  配置远程devtools 密码
spring.devtools.remote.secret=mysecret
```
**devtools默认配置如下：**
主要代码
```
   static {
        Map<String, Object> properties = new HashMap();
        properties.put("spring.thymeleaf.cache", "false");
        properties.put("spring.freemarker.cache", "false");
        properties.put("spring.groovy.template.cache", "false");
        properties.put("spring.mustache.cache", "false");
        properties.put("server.servlet.session.persistent", "true");
        properties.put("spring.h2.console.enabled", "true");
        properties.put("spring.resources.cache.period", "0");
        properties.put("spring.resources.chain.cache", "false");
        properties.put("spring.template.provider.cache", "false");
        properties.put("spring.mvc.log-resolved-exception", "true");
        properties.put("server.error.include-stacktrace", "ALWAYS");
        properties.put("server.servlet.jsp.init-parameters.development", "true");
        properties.put("spring.reactor.stacktrace-mode.enabled", "true");
        PROPERTIES = Collections.unmodifiableMap(properties);
    }
```

##  自定义重启加载器（指定哪些文件用restart classloader,哪些文件用base classloader）
创建META-INF/spring-devtools.properties文件，restart.exclude开头代表使用base classloader，restart.include代表使用restart classloader



>  **需要注意的是** 如果是用IDEA进行开发的话，需要手动进行build，devtools才会检测到文件变化


## 本地运行效果
**修改前：**

![nkVOc6.png](https://s2.ax1x.com/2019/09/03/nkVOc6.png)

**修改后：**

![nkQfw6.png](https://s2.ax1x.com/2019/09/03/nkQfw6.png)

## remote 配置（远程动态加载支持IDEA，这边我打包本地运行了模拟远程效果）

![nkRqjH.png](https://s2.ax1x.com/2019/09/03/nkRqjH.png)
### 远程运行效果
**修改前：**

![nkQfw6.png](https://s2.ax1x.com/2019/09/03/nkQfw6.png)

**修改后：**

![nkWcIP.png](https://s2.ax1x.com/2019/09/03/nkWcIP.png)