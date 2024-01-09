package com.mamba.mybatisplus.controller;

import com.mamba.mybatisplus.domain.User;
import com.mamba.mybatisplus.payload.UserDTO;
import com.mamba.mybatisplus.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String hello(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        return "success";
    }

    @GetMapping("/{userId}")
    public User hello(@PathVariable("userId")Long userId) {
        User user = userService.getById(userId);
        return user;
    }

}