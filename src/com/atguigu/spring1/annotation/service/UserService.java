package com.atguigu.spring1.annotation.service;

import com.atguigu.spring1.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 18-1-19.
 */
@Service
public class UserService {

    @Autowired
    @Qualifier("userRepositoryImpl")  //当IOC容器中有多个该接口的实现类时（不唯一），使用Qualifier指定使用哪一个实现类
    private UserRepository userRepository;

    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }

}
