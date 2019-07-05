package com.lyp.learn.demo.aop.demo04.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("aop-aspect-xml2.xml");
        //不能修改的接口类型（其实就是不能修改的接口实现类的实例）获取的是li这个bean，调用Li接口实现类的Say()方法
        //重写的接口类型（其实就是重写的接口实现类的实例）获取的也是li这个bean，调用Add接口实现类的Todo()方法
        Chinese li = (Chinese) acx.getBean("li");
        li.say();

        Add li2 = (Add) acx.getBean("li");
        li2.todo();

    }
}
