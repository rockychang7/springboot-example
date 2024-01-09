package com.mamba.mybatisplus.payload;

import lombok.Data;

@Data
public class UserDTO {

    private String username;

    private String password;

    private String phone;

    private String info;

    private Integer balance;

    private Integer status;

}
