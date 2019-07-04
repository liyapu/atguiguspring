package com.lyp.learn.demo.aop.demo03;

public class Main {
    public static void main(String[] args) {
        //创建真实对象
        ArithmeticCalculator ac = new ArithmeticCalculatorImpl();

        //根据真实对象，创建代理对象
        ArithmeticCalculator proxyAc = new ArithmeticCalculatorDynamicImpl(ac).createProxy();

        int add = proxyAc.add(10,2);
        System.out.println(add);
        System.out.println();

        int mul = proxyAc.mul(10,2);
        System.out.println(mul);
    }
}
