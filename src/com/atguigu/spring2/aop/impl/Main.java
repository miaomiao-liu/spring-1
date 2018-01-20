package com.atguigu.spring2.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-20.
 */
public class Main {

    public static void main(String[] args) {

//        创建spring的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources2/applicationContext.xml");

//        从IOC容器中获取bean的实例
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);


//        使用bean
        int result = arithmeticCalculator.add(1,2);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(12,2);
        System.out.println("result:" + result);


    }
}
