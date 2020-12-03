package com.mamba.apollo.controller;

import com.mamba.apollo.model.DataSourceBean;
import com.mamba.apollo.model.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
public class ParamTestController {

    @Autowired
    private OrderBean orderBean;

    @Autowired
    private DataSourceBean dataSourceBean;

    @GetMapping
    public String getParam(){
        return "订单类型=="+orderBean.getType()+"\n,数据库信息=="+dataSourceBean.toString();
    }
}
