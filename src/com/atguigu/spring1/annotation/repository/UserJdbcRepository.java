package com.atguigu.spring1.annotation.repository;

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
