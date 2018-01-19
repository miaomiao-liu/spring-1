package com.atguigu.spring.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 18-1-19.
 */
@Repository
public class UserJdbcRepository implements UserRepository{
    @Override
    public void save() {
        System.out.println("UserJdbcRepository save...");
    }
}
