package com.mamba.yaml;

import com.mamba.yaml.bean.PortBean;
import com.mamba.yaml.bean.YamlToPropertyBean;
import com.mamba.yaml.bean.DemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleYamlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleYamlApplication.class, args);
        System.out.println("server port :" + PortBean.getPort());
        System.out.println("participant list :" + DemoBean.getName());
        System.out.println("location list :" + YamlToPropertyBean.getLocation());

    }

}
