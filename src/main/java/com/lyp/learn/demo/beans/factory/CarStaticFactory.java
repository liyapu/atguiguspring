package com.lyp.learn.demo.beans.factory;


import java.util.HashMap;
import java.util.Map;

public class CarStaticFactory {

    public static Map<String,Car> cars = new HashMap<>();

    static {
        cars.put("audi",new Car("audi",30000));
        cars.put("bmw",new Car("bmw",40000));
    }

    public static Car getCar(String name){
        return cars.get(name);
    }
}
