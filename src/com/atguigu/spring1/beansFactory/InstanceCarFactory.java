package com.atguigu.spring1.beansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法
 * Created by miaomiao on 18-1-19.
 */
public class InstanceCarFactory {

    private Map<String,Car> cars = null;

    public InstanceCarFactory(){
        cars = new HashMap<>();
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",400000));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
