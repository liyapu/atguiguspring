package com.lyp.learn.demo.beans.relations;

import com.lyp.learn.demo.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressClient {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-config.xml");
        Address address1 = (Address) acx.getBean("address1");
        System.out.println(address1);
        System.out.println();

        Address address2 = (Address) acx.getBean("address2");
        System.out.println(address2);


        Person person1 = (Person) acx.getBean("person1");
        System.out.println(person1);
        System.out.println();

        Person person2 = (Person) acx.getBean("person2");
        System.out.println(person2);
        System.out.println();

        Person person3 = (Person) acx.getBean("person3");
        System.out.println(person3);
        System.out.println();
    }
}
