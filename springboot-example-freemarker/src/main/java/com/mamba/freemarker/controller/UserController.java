package com.mamba.freemarker.controller;

import com.mamba.freemarker.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/24 16:31
 */
@RestController
public class UserController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/login");
        return modelAndView;
    }


    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user != null && user.getPwd().equals("123") && user.getName().equals("joe")) {
            user.setDesc("i am working");
            modelAndView.addObject(user);
            modelAndView.setViewName("/index");
        } else {
            modelAndView.setViewName("/login");
        }

        return modelAndView;
    }
}