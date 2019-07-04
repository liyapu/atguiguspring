package com.lyp.learn.demo.aop.demo02;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The arithmetic add [" + i + "," + j + "]");
        int result = i + j;
        System.out.println("The arithmetic add  result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The arithmetic sub [" + i + "," + j + "]");
        int result = i - j;
        System.out.println("The arithmetic sub  result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The arithmetic mul [" + i + "," + j + "]");
        int result = i * j;
        System.out.println("The arithmetic mul  result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The arithmetic div [" + i + "," + j + "]");
        int result = i / j;
        System.out.println("The arithmetic div  result = " + result);
        return result;
    }
}
