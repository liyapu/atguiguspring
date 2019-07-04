package com.lyp.learn.demo.aop.demo04.aop03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 参数校验切面
 */
public class ValidatorAspect {

    public void beforeValid(JoinPoint joinPoint){
        System.out.println("*** ValidatorAspect 参数校验  " + Arrays.asList(joinPoint.getArgs()));
    }
}
