package com.mamba.jdbctemplate;

import com.mamba.jdbctemplate.dao.UserDao;
import com.mamba.jdbctemplate.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleJdbcTemplateApplicationTests {


    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {

        User user = new User();
        user.setUsername("james");
        user.setAge(25);
        userDao.add(user);

    }

    @Test
    public void deleteUser() {
        userDao.delete(2);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("joebig");
        user.setAge(26);

        userDao.update(user);
    }

    @Test
    public void getUser() {
        User user = userDao.get(1);
        System.out.println(user);
    }


    @Test
    public void getAllUser() {
        List<User> users = userDao.queryAllList();
        System.out.println(users);
    }
}
