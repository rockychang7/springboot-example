package com.mamba.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mamba.mybatisplus.domain.User;
import com.mamba.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

//mybatis plus这样提供了一些通用的service方法
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
