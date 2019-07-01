package com.lyp.learn.demo.beans.collections;

import com.lyp.learn.demo.beans.Car;

import java.util.Set;

public class Father {
    private Set<String>  works;
    private Set<Car> cars;

    public Set<String> getWorks() {
        return works;
    }

    public void setWorks(Set<String> works) {
        this.works = works;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Father{" +
                "works=" + works +
                ", cars=" + cars +
                '}';
    }
}
