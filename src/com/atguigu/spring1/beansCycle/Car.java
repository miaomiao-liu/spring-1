package com.atguigu.spring1.beansCycle;

/**
 * Created by miaomiao on 18-1-18.
 */
public class Car {

    private String brand;

    public Car() {
        System.out.println("Car's Constructor...");
    }

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
