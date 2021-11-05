package com.mamba.swagger2.controller;

import com.mamba.swagger2.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author JoeBig7
 * @date 2021/11/5 14:40:32
 */
@Api("用户api")
@RestController
public class UserController {


    @GetMapping("/user/{userId}")
    @ApiOperation("获取用户信息")
    public User getUser(@PathVariable("userId") Integer userId) {
        return new User("joebig7", 24, "js");
    }

    @ApiOperation("创建用户")
    @PostMapping("/user")
    public void create(@RequestBody User user) {
        System.out.println("create user =====" + user.toString());
    }
    @ApiOperation("删除用户")
    @DeleteMapping("/user")
    public void create(@RequestParam("userId") Integer userId) {
        System.out.println("delete user =====" + userId);
    }
}
