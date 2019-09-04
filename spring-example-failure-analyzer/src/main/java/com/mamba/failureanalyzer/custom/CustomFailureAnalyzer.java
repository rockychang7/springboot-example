package com.mamba.failureanalyzer.custom;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/9/4 16:51
 * @description 自定义一个启动失败处理器
 */
public class CustomFailureAnalyzer extends AbstractFailureAnalyzer<ArithmeticException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, ArithmeticException cause) {
        return new FailureAnalysis("dividend is 0", "please check your code to address the problem", cause);
    }
}