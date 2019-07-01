package com.lyp.learn.demo.beans.collections;

import com.lyp.learn.demo.beans.Car;

import java.util.Map;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-02 00:23
 */
public class Student {
    private Map<String,Integer> scores;
    private Map<String,Car> cars;

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Student{" +
                "scores=" + scores +
                ", cars=" + cars +
                '}';
    }
}
