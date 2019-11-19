## SpringBoot整合MongoDB数据库
SpringBoot支持MongoDB的自动注入，并且提供了多套Api对Mongo进行操作。

## 依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

## 操作方式
SpringBoot提供给了三种方式对MongoDB进行操作。分别是直接通过MongoDbFactory,MongoTemplate,MongoDB Repositories。这几种方式SpringBoot都已经主动注入，我们直接拿来使用即可。具体操作如下：


### MongoDbFactory (最直接)
```
@Autowired
private MongoDbFactory mongoDbFactory;
```
可以直接注入MongoDbFactory来获取对象进行Api操作，具体参见代码。这种方式属于原生的操作方式，并没有进行上层的封装。

### MongoTemplate
```
@Autowired
private MongoTemplate mongoTemplate;
```
在MongoTemplate注入后，就可以通过它来进行操作，具体参见代码

>  需要注意的是,使用MongoTemplate需要预先在properties中配置好database，当然也可以进行设置。

### MongoDB Repositories
MongoDB Repositories的使用方式和Jpa中的类似，只需要定义好接口并继承好MongoRepository即可，具体也是参见代码。




### 扩展
Mongo的安装地址可以前往此处进行参考[传送门](https://docs.mongodb.com/manual/installation/)