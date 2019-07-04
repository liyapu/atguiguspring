package com.lyp.learn.demo.beans.factory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getObject() throws Exception {
        return new Car(name,50000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
