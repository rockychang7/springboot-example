package com.mamba.mongo.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/19 16:11
 * @description
 */
public class Custom {


    public Custom(Long id, String name, Date createTime, String address) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.address = address;
    }

    @Id
    private Long id;

    private String name;

    private Date createTime;

    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}