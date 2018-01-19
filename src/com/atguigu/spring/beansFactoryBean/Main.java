package com.atguigu.spring.beansFactoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-19.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-factorybean.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
    }
}
