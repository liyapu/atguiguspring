package com.lyp.learn.demo.aop.demo04.aop04;

/**
 * 自定义接口实现类
 */
public class DoSomething implements Add {
    @Override
    public void todo() {
        System.out.println("我在中国准备做些事情...");
    }
}
