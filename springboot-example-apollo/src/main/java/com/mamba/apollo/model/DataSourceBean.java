package com.mamba.apollo.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceBean {

    private String url;

    private String username;

    private String password;
}
