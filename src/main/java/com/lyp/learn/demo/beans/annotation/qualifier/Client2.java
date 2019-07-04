package com.lyp.learn.demo.beans.annotation.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        DataService dataService = (DataService) acac.getBean("dataService");
        System.out.println(dataService);
        dataService.add();
    }
}
