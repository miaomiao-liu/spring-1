package com.atguigu.spring.beans;

/**
 * Created by miaomiao on 18-1-13.
 */
public class HelloWord {

    private String name;

    public void setName(String name) {
        System.out.println("name " + name);
        this.name = name;
    }

    public void hello(){
        System.out.println("hello : " + name);
    }

    public HelloWord() {
        System.out.println("HelloWorld's Constructor...");
    }
}
