package com.atguigu.spring.beansScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-18.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-scope.xml");

        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");

        System.out.println(car == car2);


    }



}
