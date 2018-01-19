package com.atguigu.spring.beansCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-19.
 */
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-cycle.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        //关闭IOC容器
        ctx.close();
    }
}
