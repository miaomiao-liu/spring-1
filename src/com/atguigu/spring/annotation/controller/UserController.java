package com.atguigu.spring.annotation.controller;

import com.atguigu.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by miaomiao on 18-1-19.
 */
@Controller
public class UserController {

    //@Resource @Inject 也可以自动装配bean
    @Autowired
    private UserService userService;

    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
