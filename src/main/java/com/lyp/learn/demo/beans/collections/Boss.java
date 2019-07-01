package com.lyp.learn.demo.beans.collections;

import com.lyp.learn.demo.beans.Car;

import java.util.List;

public class Boss {

    private List<String>  houses;

    private List<Car> cars;

    public List<String> getHouses() {
        return houses;
    }

    public void setHouses(List<String> houses) {
        this.houses = houses;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "houses=" + houses +
                ", cars=" + cars +
                '}';
    }
}
