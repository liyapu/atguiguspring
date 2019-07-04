package com.lyp.learn.demo.aop.demo01;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator ac = new ArithmeticCalculatorImpl();

        int add = ac.add(10,2);
        System.out.println(add);
        System.out.println();

        int mul = ac.mul(10,2);
        System.out.println(mul);
    }
}
