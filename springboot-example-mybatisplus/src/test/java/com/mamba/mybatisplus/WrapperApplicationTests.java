package com.mamba.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mamba.mybatisplus.domain.User;
import com.mamba.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getUsername, User::getInfo, User::getBalance)
                .like(User::getUsername, "o")
                .ge(User::getBalance, 1000);

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void updateWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("username", "rocky");

        User user = new User();
        user.setBalance(1200);
        userMapper.update(user, wrapper);
    }

}
