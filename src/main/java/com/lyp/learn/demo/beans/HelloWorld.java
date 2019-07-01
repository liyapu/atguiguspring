package com.lyp.learn.demo.beans;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-01 15:28
 */
public class HelloWorld {
    private String name;

    public HelloWorld(){
       // System.out.println("HelloWorld's Constructor....");
    }

    public void setName(String name) {
        //System.out.println("setName ......");
        this.name = name;
    }

    public void hello(){
        System.out.println("hello : " + name);
    }
}
