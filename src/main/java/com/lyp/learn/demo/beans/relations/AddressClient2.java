package com.lyp.learn.demo.beans.relations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressClient2 {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-config.xml");
        Address address1 = (Address) acx.getBean("address");
        Address address2 = (Address) acx.getBean("address");

        System.out.println(address1 == address2);
        System.out.println(address1.hashCode());
        System.out.println(address2.hashCode());
    }
}
