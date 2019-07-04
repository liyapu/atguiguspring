package com.lyp.learn.demo.beans.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Dog implements BeanNameAware,BeanFactoryAware,
        ApplicationContextAware,InitializingBean,DisposableBean {
    private String name;

    public Dog(){
        System.out.println("Dog's conctructor ....");
    }

    public void setName(String name) {
        System.out.println("Dog's setName ......");
        this.name = name;
    }

    public void myselfInit(){
        System.out.println("myselfInit .....");
    }

    public void myselfDestory(){
        System.out.println("myselfDestory ......");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware : setBeanName : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware : setBeanFactory :" );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware : setApplicationContext : " + applicationContext.getApplicationName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean : afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean : destory");
    }
}
