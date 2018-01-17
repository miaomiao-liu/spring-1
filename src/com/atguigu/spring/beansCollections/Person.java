package com.atguigu.spring.beansCollections;

import com.atguigu.spring.beans.Car;

import java.util.List;

/**
 * Created by miaomiao on 17-9-13.
 */
public class Person {
    private String name;
    private int age;
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + cars +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }
}
/*

*
* */
