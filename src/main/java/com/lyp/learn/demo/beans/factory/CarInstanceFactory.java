package com.lyp.learn.demo.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-03 18:52
 */
public class CarInstanceFactory {
    public Map<String,Car> cars = null;

    public CarInstanceFactory(){
        cars = new HashMap<>();
        cars.put("audi",new Car("audi",30000));
        cars.put("bmw",new Car("bmw",40000));
    }

    public Car getCar(String name){
        return cars.get(name);
    }
}
