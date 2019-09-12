package com.mamba.yaml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/11 17:07
 * @description 使用@ConfigurationProperties读取默认ymal配置文件中的属性
 *  注意如果想测试请注释掉YamlToPropConfig 不然会读取指定的配置文件
 */
@Configuration
@ConfigurationProperties(prefix = "department")
public class DemoBean {


    public static List<String> name;


    public static List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        DemoBean.name = name;
    }

}