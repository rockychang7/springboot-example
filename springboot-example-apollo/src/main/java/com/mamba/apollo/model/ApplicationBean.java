package com.mamba.apollo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBean {

    @Value("${type:2}")
    private Integer timeout;
}
