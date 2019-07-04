package com.lyp.learn.demo.aop.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理
 */
public class ArithmeticCalculatorDynamicImpl implements InvocationHandler {

    //持有真实对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorDynamicImpl(ArithmeticCalculator target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("The arithmetic " + method.getName() + " " + Arrays.asList(args) + "");
        Object result = method.invoke(target,args);
        System.out.println("The arithmetic " + method.getName() + " result = " + result);
        return result;
    }

    public ArithmeticCalculator createProxy(){
        return (ArithmeticCalculator)
                Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ArithmeticCalculatorDynamicImpl(target));
    }
}
