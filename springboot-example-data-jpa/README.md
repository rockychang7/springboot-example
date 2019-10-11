## SpringBoot整合Spring-data-jpa
SpringBoot可以自动注入Spring jpa，通过jpa的标准来访问数据库。值得注意的是Spring Jpa底层也是基于的Hibernate。

## 依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```

## Spring Jpa特点
Spring Jpa简化了访问数据库的操作，Spring会通过代理自动生成我们需要的操作，我们需要的做的就是定义好符合规则的接口


## 操作
1. CRUD操作： 定义dao层接口用来访问数据库,通过继承CrudRepository我们本身就拥有了对数据库的基本操作，并且可以自己定义方法如下则代表按照username进行查询。
```
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsername(String username);
}

```


2. 分页操作:可以通过继承PagingAndSortingRepository来实现，同时支持排序。
```
public interface PageRepository extends PagingAndSortingRepository<User, Integer> {


}
```

3. 可以自定义Repository类如果不想继承Spring提供的,通过@RepositoryDefinition注解
```
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface CustomRepository {
    List<User> findByUsername(String username);
}
```

> 详细操作可以查看SpringBootExampleDataJpaApplicationTests类中实现