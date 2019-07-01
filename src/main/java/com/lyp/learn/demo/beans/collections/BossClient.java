package com.lyp.learn.demo.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BossClient {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-context.xml");
        Boss boss = (Boss) acx.getBean("boss");
        System.out.println(boss);
        System.out.println();

        Boss boss2 = (Boss) acx.getBean("boss2");
        System.out.println(boss2);

        System.out.println();
        Mother mother = (Mother) acx.getBean("mother");
        System.out.println(mother);

        System.out.println();
        Father father = (Father) acx.getBean("father");
        System.out.println(father);

        System.out.println();
        Student student = (Student) acx.getBean("student");
        System.out.println(student);

        System.out.println();
        DataSource dataSource = (DataSource) acx.getBean("dataSource");
        System.out.println(dataSource);
    }
}
