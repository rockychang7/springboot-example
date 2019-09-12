package com.mamba.yaml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/12 12:58
 * @description 获取不同环境port值
 */
@Configuration
public class PortBean {


    public static Integer port;


    public static Integer getPort() {
        return port;
    }
    @Value("${server.port}")
    public void setPort(Integer port) {
        PortBean.port = port;
    }
}