## SpringBoot整合Spring Security 配置jwt 实现注册登录


## 核心实现
- WebSecurityConfig继承自WebSecurityConfigurerAdapter，核心配置类
```java
1. @EnableWebSecurity 用来开启spring security自动装配

2. configure(AuthenticationManagerBuilder authenticationManagerBuilder) 指定了UserDetailsServiceImpl和BCryptPasswordEncoder分来来进行加载用户信息和加密用户密码

3. configure(HttpSecurity http)用来配置组织csrf和cors、配置请求url的权限
```
 
 - JwtUtils  生成和检查token工具类
 
 - AuthTokenFilter 检查token是否合法