package com.atguigu.spring1.beansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法
 * Created by miaomiao on 18-1-19.
 */
public class StaticCarFactory {

    private static Map<String,Car> cars = new HashMap<>();

    static {
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",400000));
    }

    private static Car getCar(String name){
        return cars.get(name);
    }
}
