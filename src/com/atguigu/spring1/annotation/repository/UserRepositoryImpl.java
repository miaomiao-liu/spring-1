package com.atguigu.spring1.annotation.repository;

import com.atguigu.spring1.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 18-1-19.
 */
//通过value属性值来表示类在IOC容器中的名字
@Repository
public class UserRepositoryImpl implements UserRepository {

//required = false : 当IOC容器中没有这个bean时，不会报错，返回null
    @Autowired(required = false)
    TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepository Save...");
        System.out.println(testObject);
    }
}
