package com.atguigu.spring.beansGenericDi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by miaomiao on 18-1-19.
 */
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> baseRepository;

    public void add(){
        System.out.println("add...");
        System.out.println(baseRepository);
    }
}
