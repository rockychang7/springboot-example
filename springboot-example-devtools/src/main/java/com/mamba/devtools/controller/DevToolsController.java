package com.mamba.devtools.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/8/23 18:01
 * @description HelloWorld demo
 */

@RestController
public class DevToolsController {

    @RequestMapping("/devtools")
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "rocky");
        map.put("age","28");
        map.put("address","earth");
        return map;
    }

}