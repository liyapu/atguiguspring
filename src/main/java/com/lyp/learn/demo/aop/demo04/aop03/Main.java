package com.lyp.learn.demo.aop.demo04.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /**
         * 通过配置的 xml文件，组装配置spring bean,aop切面
         */
        ApplicationContext acx = new ClassPathXmlApplicationContext("aop-aspect-xml.xml");

        ArithmeticCalculator ac = acx.getBean(ArithmeticCalculator.class);
        int add = ac.add(10, 2);
        System.out.println(add);
        System.out.println();

        //除0可以模拟异常，验证 异常通知
        int div = ac.div(20, 4);
        System.out.println(div);
    }
}
