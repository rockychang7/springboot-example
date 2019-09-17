## SpringBoot整合日志框架Logback

### 依赖
由于SpringBoot默认整合了Logback依赖，因此不需要额外地添加依赖
```
   </dependencies>	
       <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
	</dependencies>	
```

### 默认配置
SpringBoot提供了logback的默认配置，位于spring-boot.jar的org/springframework/boot/logging/logback/base.xml，包含配置如下：可以看见default.xml提供了默认转换规则、全局属性以及logger的配置；console-appender.xml中定义了console输出的具体配置；在file-appender.xml中定义了文件输出的具体配置。

base.xml：
```
<?xml version="1.0" encoding="UTF-8"?>
<included>
	<include resource="org/springframework/boot/logging/logback/defaults.xml" />
	<property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/spring.log}"/>
	<include resource="org/springframework/boot/logging/logback/console-appender.xml" />
	<include resource="org/springframework/boot/logging/logback/file-appender.xml" />
	<root level="INFO">
		<appender-ref ref="CONSOLE" />
		<appender-ref ref="FILE" />
	</root>
</included>
```

default.xml配置如下:
```
    <?xml version="1.0" encoding="UTF-8"?>
 
    <included>
    	<conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter" />
    	<conversionRule conversionWord="wex" converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter" />
    	<conversionRule conversionWord="wEx" converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter" />
    	<property name="CONSOLE_LOG_PATTERN" value="${CONSOLE_LOG_PATTERN:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    	<property name="FILE_LOG_PATTERN" value="${FILE_LOG_PATTERN:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    
    	<logger name="org.apache.catalina.startup.DigesterFactory" level="ERROR"/>
    	<logger name="org.apache.catalina.util.LifecycleBase" level="ERROR"/>
    	<logger name="org.apache.coyote.http11.Http11NioProtocol" level="WARN"/>
    	<logger name="org.apache.sshd.common.util.SecurityUtils" level="WARN"/>
    	<logger name="org.apache.tomcat.util.net.NioSelectorPool" level="WARN"/>
    	<logger name="org.eclipse.jetty.util.component.AbstractLifeCycle" level="ERROR"/>
    	<logger name="org.hibernate.validator.internal.util.Version" level="WARN"/>
    </included>

```

console-appender.xml：
```
    <?xml version="1.0" encoding="UTF-8"?>

    <included>
    	<appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    		<encoder>
    			<pattern>${CONSOLE_LOG_PATTERN}</pattern>
    		</encoder>
    	</appender>
    </included>

```

file-appender.xml
```
    <?xml version="1.0" encoding="UTF-8"?>
    
    <included>
    	<appender name="FILE"
    		class="ch.qos.logback.core.rolling.RollingFileAppender">
    		<encoder>
    			<pattern>${FILE_LOG_PATTERN}</pattern>
    		</encoder>
    		<file>${LOG_FILE}</file>
    		<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
    			<fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
    			<maxFileSize>${LOG_FILE_MAX_SIZE:-10MB}</maxFileSize>
    			<maxHistory>${LOG_FILE_MAX_HISTORY:-0}</maxHistory>
    		</rollingPolicy>
    	</appender>
    </included>

```

###  自定义logback.xml
除了使用SpringBoot默认的配置，还可以自定义logback配置文件，并且放在项目类路径下就能生效。具体的配置文件如下：下面的配置文件还使用了springProfile对不同运行环境使用不同的日志输出，这是SpringBoot对logback特别提供的。

logback-spring.xml
```
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration scan="true">
        <!--定义上下文名称-->
        <contextName>logback-demo</contextName>
        <!--引用了默认配置default.xml-->
        <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
        <!--定义变量LOG_FILE FILE_LOG_PATTERN-->
        <property name="LOG_FILE" value="D:/"/>
        <property name="FILE_LOG_PATTERN" value="${FILE_LOG_PATTERN:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    
        <!--springboot 支持springProfile 针对不同环境可以配置不同的输出-->
        <springProfile name="default">
            <include resource="org/springframework/boot/logging/logback/console-appender.xml"/>
            <logger name="com.mamba.logback" level="DEBUG"/>
    
            <root level="info">
                <appender-ref ref="CONSOLE"/>
            </root>
        </springProfile>
    
        <!--配置dev环境输出配置-->
        <springProfile name="dev">
            <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
                <encoder>
                    <pattern>"${CONSOLE_LOG_PATTERN:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss}}){faint}
                        %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint}
                        %clr(%-40.40logger{39}){red} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}
                    </pattern>
                </encoder>
            </appender>
    
            <root level="info">
                <appender-ref ref="CONSOLE"/>
            </root>
        </springProfile>
    
    
        <!--配置prod环境输出配置-->
        <springProfile name="prod">
            <include resource="org/springframework/boot/logging/logback/console-appender.xml"/>
            <appender name="FILE"
                      class="ch.qos.logback.core.rolling.RollingFileAppender">
                <encoder>
                    <pattern>${FILE_LOG_PATTERN}</pattern>
                </encoder>
                <file>${LOG_FILE}springboot.log</file>
                <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
                    <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
                    <maxFileSize>${LOG_FILE_MAX_SIZE:-10MB}</maxFileSize>
                    <maxHistory>${LOG_FILE_MAX_HISTORY:-0}</maxHistory>
                </rollingPolicy>
            </appender>
            <logger name="com.mamba.logback" level="INFO"/>
    
            <root level="DEBUG">
                <appender-ref ref="CONSOLE"/>
                <appender-ref ref="FILE"/>
            </root>
        </springProfile>
    </configuration>
```


> 需要注意的是，SpringBoot本身提供的日志相关配置属性是独立于logback的，如果要测试这些属性，需要将logback-spring移除，不然SpringBoot会覆盖掉这些属性。