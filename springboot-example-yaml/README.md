## SpringBoot对yaml配置文件的支持
SpringBoot默认支持properties和yaml配置文件，本例展示了yaml的主要使用特性

### 主要语法 1  
```
   participant:
   dev:
       name: joebig7
   test:
       name: tom
```
等同于application中
```
   participant.dev.name=joebig7
   participant.test.name=tom
```

### 主要语法 2 （配置数组）
``` 
    department:
        name:
          - develop
          - market
```
等同于application中
```
    department.name[0]=develop
    department.name[1]=market
```

### 配置不同环境的属性
```
   server:
    	port: 8080
    ---
    spring:
    	profiles: development
    server:
    	port: 8081
    ---
    spring:
    	profiles: production & eu-central
    server:
    	port: 8082
```

### 读取yaml文件的两种方式
**（1）** 使用@ConfigurationProperties：SpringBoot默认就支持通过该注解读取默认yaml配置文件

**（2）** 使用@Value读取 ：这种方式也可以对属性进行读取，但是针对读取List@Value不支持上述的配置语法。可以通过value1,value2...的格式进行配置


-----------------------

### 注意事项
SpringBoot默认不支持使用@PropertySource来载入yaml配置文件，不过可以通过YamlPropertySourceLoader类来将指定的yaml注册成PropertySource。本例给出了YamlToPropConfig配置类解决了这个问题。