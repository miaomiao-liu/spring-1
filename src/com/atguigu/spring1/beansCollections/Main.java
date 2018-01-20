package com.atguigu.spring1.beansCollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-13.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources1/applicationContext.xml");

        Person person3 = (Person) ctx.getBean("person3");
        System.out.println(person3);

        NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
        System.out.println(newPerson);

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

        Person person4 = (Person) ctx.getBean("person4");
        System.out.println(person4);

        Person person5 = (Person) ctx.getBean("person5");
        System.out.println(person5);

    }
}
