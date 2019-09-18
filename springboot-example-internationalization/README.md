## Springboot如何支持国际化

## 什么是国际化
国际化是针对不同的国家语言，根据客户端系统或者指定默认语言来显示指定区域的内容
### 依赖
这边通过thymeleaf来展示结果，使用web来进行内容请求
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 配置
**(1)** :需要指定资源包，默认SpringBoot会查找类路径下的messages.properties配置文件，不同区域则对应不同的变种(如messages_zh_CN.properties)。这边我存放在了i18n/messages下，需要注意的是如果自定义位置，则需要配置spring.messages.basename（可以用逗号分隔）：`spring.messages.basename=i18n/messages`
 

 **(2)**: 定义了接收数据的模板文件:
 ```
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset = "UTF-8"/>
        <title>Internationalization</title>
        </head>
        <body>
        <h1 th:text = "#{title}"></h1>
        <h1 th:text = "#{language.name}"></h1>
        <h1 th:text = "#{language.age}"></h1>
        
        </body>
        </html>
 ```
 
  **(3)**: 注册：本地解决方案（这边指定了US为默认的LocaleResolver）、配置拦截器（这边通过lang开头的参数来决定是否变换区域）
  ```
        @Configuration
        public class I18nConfig extends WebMvcConfigurerAdapter {
        
        @Bean
        public LocaleResolver localeResolver() {
            SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
            sessionLocaleResolver.setDefaultLocale(Locale.US);
            return sessionLocaleResolver;
        }
        
        @Bean
        public LocaleChangeInterceptor localeChangeInterceptor() {
            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
            localeChangeInterceptor.setParamName("lang");
            return localeChangeInterceptor;
        }
        
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(localeChangeInterceptor());
        }
        }
  ```
  
  > 值得一提的是，SpringBoot只是对一些参数进行自动配置，默认还是使用的Spring的MessageResource接口做具体的实现，这边注册呢它的一个实现类SessionLocaleResolver来对请求内容进行处理。