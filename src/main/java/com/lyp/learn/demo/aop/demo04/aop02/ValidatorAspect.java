package com.lyp.learn.demo.aop.demo04.aop02;

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
    /**
     * 同一个包中:
     * 通过 类名.方法名 引用
     *
     * 不同包中:
     * 通过 包名.类名.方法名
     * @param joinPoint
     */
    @Before("LoggerAspect.declareJoinPointExpression()")
    public void beforeValid(JoinPoint joinPoint){
        System.out.println("*** ValidatorAspect 参数校验  " + Arrays.asList(joinPoint.getArgs()));
    }
}
