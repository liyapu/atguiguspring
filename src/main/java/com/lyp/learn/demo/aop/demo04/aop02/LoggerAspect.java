package com.lyp.learn.demo.aop.demo04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面
 * 1.首先让其受 spring 管理，添加 @Component注解
 * 2.声明为一个切面,添加 @Aspect注解
 */

@Component
@Aspect
@Order(2)
public class LoggerAspect {

    /**
     * 定义一个方法，用于声明切入点表达式，一般不在写代码
     *  减少重复的表达式
     * 使用@Pointcut 来声明切入点表达式
     */
    @Pointcut("execution( * com.lyp.learn.demo.aop.demo04.aop02.ArithmeticCalculator.*(..))")
    public void  declareJoinPointExpression(){
    }

    /**
     * 声明该方法为一个前置通知，在目标方法之前执行
     */

    //ArithmeticCalculator 中的所有方法
   @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取方法参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("The arithmetic " + methodName + " " + Arrays.asList(args) + " beforeMethod");
    }

    /**
     * 后置通知：在目标方法执行后(不管是否发生异常)，执行的通知
     * 在后置通知中还不能访问目标方法执行的结果，需要在 返回通知 里去访问
     * @param joinPoint
     */
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The arithmetic " + methodName + " end. afterMethod");
    }

    /**
     * 返回通知
     * 在方法正常结束后执行的代码
     * 返回通知时可以访问到方法的返回值的
     * @param joinPoint
     */
    @AfterReturning(value = "declareJoinPointExpression()",
                returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The arithmetic " + methodName + " result = " + result + " end. afterReturningMethod");
    }

    /**
     * 异常通知
     * afterThrowMethod 方法中，指定的异常包含目标方法实际抛出的异常时，
     *  才能捕获到此异常，才会执行，否则此异常通知不会执行
     */
    @AfterThrowing(value = "declareJoinPointExpression()",
            throwing = "ex")
    public void afterThrowMethod(JoinPoint joinPoint,Exception ex){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The arithmetic " + methodName + " " +
                " afterThrowMethod occurs Exception . " +  ex.getMessage());
    }

    /**
     * 环绕通知
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjd
     * @return
     */
    @Around("declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;
        String methodName = pjd.getSignature().getName();
        try {
            //前置通知
            System.out.println("aroundMethod --- " + methodName + " before " + Arrays.asList(pjd.getArgs()) );
            //执行目标方法
            result = pjd.proceed();
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("aroundMethod --- " + methodName + " afterThrowing " + throwable );
        }finally {
            //后置通知
            System.out.println("aroundMethod --- " + methodName + " after "  );
        }
        //返回通知
        System.out.println("aroundMethod --- " + methodName + " afterReturning  result = " + result );
        return result;

    }
















}
