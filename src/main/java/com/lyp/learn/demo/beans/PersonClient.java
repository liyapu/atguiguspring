package com.lyp.learn.demo.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-01 22:22
 */
public class PersonClient {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-context.xml");
        Person person = (Person) acx.getBean("person1");
        System.out.println(person);

        System.out.println();
        Person person2 = (Person) acx.getBean("person2");
        System.out.println(person2);
    }
}
