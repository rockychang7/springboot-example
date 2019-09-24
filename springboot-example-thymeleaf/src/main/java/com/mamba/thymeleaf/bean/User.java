package com.mamba.thymeleaf.bean;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/24 16:39
 */
public class User {

    private String name;
    private String desc;

    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}