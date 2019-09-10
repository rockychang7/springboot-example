package com.mamba.externalizedconfiguration.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/10 17:37
 * @description 测试bean
 */
@Component
public class User {


    private String name = "";

    public User(@Value("${name}") String name) {
        System.out.println("name===" + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}