package com.mamba.testing.service;

import org.springframework.stereotype.Service;

/**
 * @Author JoeBig7
 * @date 2022/3/10 17:39:44
 * @descriptio 测试User类
 */
@Service
public class UserServiceImpl {

    public String login(String password, String username) {
        if ("123".equals(password)) {
            return "password is too simple";
        }

        return "login succes,your pwd is " + password + " and username is " + username;
    }

}
