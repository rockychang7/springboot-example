package com.mamba.apollo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderBean {

    @Value("${type:2}")
    private Integer type;
}
