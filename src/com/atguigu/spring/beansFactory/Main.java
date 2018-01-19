package com.atguigu.spring.beansFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-19.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-factory.xml");

        Car car = (Car) ctx.getBean("car1");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
    }
}
