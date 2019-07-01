package com.lyp.learn.demo.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-01 15:34
 */
public class Client2 {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-context.xml");
        HelloWorld helloWorld = (HelloWorld) acx.getBean("helloWorld");
        helloWorld.hello();
    }
}
