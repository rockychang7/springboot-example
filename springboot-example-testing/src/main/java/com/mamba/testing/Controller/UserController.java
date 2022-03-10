package com.mamba.testing.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JoeBig7
 * @date 2022/3/10 18:33:23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String id) {
        return id + " Joe";
    }
}
