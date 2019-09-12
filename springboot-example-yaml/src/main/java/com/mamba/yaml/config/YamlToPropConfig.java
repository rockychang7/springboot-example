package com.mamba.yaml.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/11 18:55
 * @description 配置类 将yaml配置文件转换成PropetySource注册在Spring Env中
 */
@Configuration
public class YamlToPropConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer properties() throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        MutablePropertySources sources = new MutablePropertySources();
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        List<PropertySource<?>> propertySources = loader.load("test", new ClassPathResource("test.yaml"));
        propertySources.forEach(propertySource -> {
            sources.addLast(propertySource);
        });

        configurer.setPropertySources(sources);
        return configurer;
    }
}