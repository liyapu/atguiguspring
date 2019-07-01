package com.lyp.learn.demo.beans;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-01 19:59
 */
public class Car {
    private String company;
    private String brand;

    private int maxSpeed;
    private float price;

    public Car(String company, String brand, float price) {
        super();
        this.company = company;
        this.brand = brand;
        this.price = price;
    }

    public Car(String company, String brand, int maxSpeed) {
        super();
        this.company = company;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public Car(String company, String brand, int maxSpeed, float price) {
        super();
        this.company = company;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Car [company=" + company + ", brand=" + brand + ", maxSpeed="
                + maxSpeed + ", price=" + price + "]";
    }
}
