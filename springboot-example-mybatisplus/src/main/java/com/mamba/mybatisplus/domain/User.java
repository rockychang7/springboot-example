package com.mamba.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    //指定id名称和生成方式
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //指定字段名字
    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    private String phone;

    private String info;

    private Integer status;

    private Integer balance;

    private Date createTime;

    private Date updateTime;
}
