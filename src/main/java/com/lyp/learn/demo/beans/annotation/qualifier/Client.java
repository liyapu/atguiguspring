package com.lyp.learn.demo.beans.annotation.qualifier;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-annotation.xml");

        DataService dataService = (DataService) acx.getBean("dataService");
        System.out.println(dataService);

        dataService.add();



    }
}
