package com.lyp.learn.demo.beans.collections;

import com.lyp.learn.demo.beans.Car;

import java.util.Arrays;

public class Mother {
    private String [] hobbies;
    private Car[] cars;

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Mother{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
