package com.lyp.learn.demo.aop.demo04.aop01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 参数校验切面
 *
 * 可以使用 Order注解，指定切面的优先级，值越小优先级越高
 */
@Component
@Aspect
@Order(1)
public class ValidatorAspect {

    @Before("execution( * com.lyp.learn.demo.aop.demo04.aop01.ArithmeticCalculator.*(..))")
    public void beforeValid(JoinPoint joinPoint){
        System.out.println("*** ValidatorAspect 参数校验  " + Arrays.asList(joinPoint.getArgs()));
    }
}
