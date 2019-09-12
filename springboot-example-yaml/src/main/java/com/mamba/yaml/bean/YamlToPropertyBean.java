package com.mamba.yaml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/11 17:52
 * @description 使用@Value读取指定yaml(test.yaml)配置文件中属性
 *     注意要开启此功能请务必配合YamlToPropConfig一起使用
 */

@Configuration
public class YamlToPropertyBean {
    public static List<String> name;


    public static List<String> getName() {
        return name;
    }
    @Value("${department.name}")
    public void setName(List<String> name) {
        DemoBean.name = name;
    }

    public static String location;

    public static String getLocation() {
        return location;
    }

    @Value("${location[0]}")
    public void setLocation(String location) {
        YamlToPropertyBean.location = location;
    }
}
