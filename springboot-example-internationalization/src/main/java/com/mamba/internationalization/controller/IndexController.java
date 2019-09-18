package com.mamba.internationalization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/18 14:52
 */
@Controller
public class IndexController {

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
}