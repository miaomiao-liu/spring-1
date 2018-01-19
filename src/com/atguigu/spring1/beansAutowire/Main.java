package com.atguigu.spring1.beansAutowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-17.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-autowire.xml");

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
