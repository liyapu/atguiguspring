package com.lyp.learn.demo.beans.life;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext acx = new ClassPathXmlApplicationContext("beans-life.xml");

        Dog dog = (Dog) acx.getBean("dog");
        System.out.println("使用:" + dog);

        //关闭容器
        acx.close();

    }
}
