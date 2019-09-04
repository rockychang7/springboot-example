package com.mamba.failureanalyzer.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/4 17:04
 * @description
 */
@Service
public class CalculateService {

    static {
        int a = 1 / 0;
    }
}