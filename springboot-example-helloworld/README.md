# springboot-example-helloworld
这个案例是用来开启项目的第一个案例Hello world

## pom配置文件
```
  	<dependencies>
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-web</artifactId>
  		</dependency>
  		
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
        </dependency>
  	</dependencies>

```

## 设计代码
**(1)Controller**:
```
  @RestController
  public class HelloWorldController {
  
      @RequestMapping("/hello")
      public String hello() {
          return "Hello World";
      }
  }
```

**(2)启动类**
```
 @SpringBootApplication
 public class SpringbootExampleHelloworldApplication {
 
 	public static void main(String[] args) {
 		SpringApplication.run(SpringbootExampleHelloworldApplication.class, args);
 	}
 }
```