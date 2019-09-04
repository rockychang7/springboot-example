## 什么FailureAnalyzer
springboot提供的用来处理启动时发生问题的抽象类
## 作用
SpringBoot本身提供了很多FailureAnalyzer实现，用来解决一些常见的可能遇见的问题比如端口占用。用户可以自定义自己项目的错误解决类。

 
## 相关配置(META-INF/spring.factories)
在spring.factories注册自定义的FailureAnalyzer实现类
```
   org.springframework.boot.diagnostics.FailureAnalyzer=\
   com.mamba.failureanalyzer.custom.CustomFailureAnalyzer
```
  
## 实现效果
![nZSOF1.png](https://s2.ax1x.com/2019/09/04/nZSOF1.png)