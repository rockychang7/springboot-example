package com.mamba.mybatisplus;


import com.mamba.mybatisplus.domain.User;
import com.mamba.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BaseMapperApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testAddUser() {

        User user = User.builder()
                    .phone("1862164345")
                    .balance(2000)
                    .status(0)
                    .password("123456")
                    .info("{}")
                    .username("rocky2") .build();

        userMapper.insert(user);
    }

    @Test
    public void delUser() {
        userMapper.deleteById(111);
    }

    @Test
    public void updateUser() {
        User user = User.builder()
                .id(5L)
                .phone("1862164347")
                .balance(20000)
                .status(0)
                .password("1234576")
                .info("{}")
                .username("rocky") .build();
        userMapper.updateById(user);
    }

    @Test
    public void findUser() {

        User user = userMapper.selectById(5);

        System.out.println(user);
    }

}
