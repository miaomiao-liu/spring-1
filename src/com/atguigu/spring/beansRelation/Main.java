package com.atguigu.spring.beansRelation;

import com.atguigu.spring.beansAutowire.Address;
import com.atguigu.spring.beansAutowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-18.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-relation.xml");

//        Address address = (Address) ctx.getBean("address");
//        System.out.println(address);

        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        Address address3 = (Address) ctx.getBean("address3");
        System.out.println(address3);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
