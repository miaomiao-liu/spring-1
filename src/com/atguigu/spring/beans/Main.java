package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-13.
 */
public class Main {

    public static void main(String[] args) {

        /*
        HelloWord helloWord = new HelloWord();
        helloWord.setName("atguigu");
        */

        //1.创建spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        /*
        //2.从IOC容器中获取bean实例
        HelloWord helloWord = (HelloWord) ctx.getBean("helloWorld");

        helloWord.hello();
        */

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);

    }
}
