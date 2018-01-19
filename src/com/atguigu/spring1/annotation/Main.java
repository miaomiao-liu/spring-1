package com.atguigu.spring1.annotation;

import com.atguigu.spring1.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-19.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/beans-annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);

//        UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
//        System.out.println(userRepository);

    }
}
