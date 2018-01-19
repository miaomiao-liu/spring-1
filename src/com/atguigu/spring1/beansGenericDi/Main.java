package com.atguigu.spring1.beansGenericDi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 4.0新特性：
 * 泛型依赖注入
 * Created by miaomiao on 18-1-19.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-generic-di.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
