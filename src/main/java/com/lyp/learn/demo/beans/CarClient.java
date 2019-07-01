package com.lyp.learn.demo.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-01 20:02
 */
public class CarClient {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-context.xml");

        Car car1 = (Car) acx.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) acx.getBean("car2");
        System.out.println(car2);
    }
}
