package com.lyp.learn.demo.beans.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext acx = new ClassPathXmlApplicationContext("beans-life.xml");

        Car car1 = (Car) acx.getBean("car1");
        System.out.println(car1);
        System.out.println();

        Car car2 = (Car) acx.getBean("car2");
        System.out.println(car2);

        Car car3 = (Car) acx.getBean("car3");
        System.out.println(car3);

    }
}
