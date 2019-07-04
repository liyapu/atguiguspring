package com.lyp.learn.demo.beans.annotation;


import com.lyp.learn.demo.beans.annotation.controller.UserController;
import com.lyp.learn.demo.beans.annotation.repository.UserRepository;
import com.lyp.learn.demo.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-annotation.xml");

//        TestObject testObject = (TestObject) acx.getBean("testObject");
//        System.out.println(testObject);

        UserController userController = (UserController) acx.getBean("userController");
        System.out.println(userController);

        UserService userService = (UserService) acx.getBean("userServiceImpl");
        System.out.println(userService);

        UserRepository userRepository = (UserRepository) acx.getBean("userRepository");
        System.out.println(userRepository);
    }
}
