package com.mamba.aop.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {

    @Around("execution(* com.mamba.aop.controller.*.*(..))")
    public void recordTime(ProceedingJoinPoint point){
        try {
            System.out.println("start==="+System.currentTimeMillis());
            point.proceed();
            System.out.println("end==="+System.currentTimeMillis());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }
}
