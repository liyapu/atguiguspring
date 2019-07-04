package com.lyp.learn.demo.beans.generite;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-generite.xml");

        UserService userService = (UserService) acx.getBean("userService");
        System.out.println(userService);
        userService.add();

        System.out.println();

        AnimalService animalService = (AnimalService) acx.getBean("animalService");
        System.out.println(animalService);
        animalService.add();
    }
}
