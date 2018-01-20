package com.atguigu.spring3.aopXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by miaomiao on 18-1-20.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources3/applicationContext-xml.xml");

        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        int result = arithmeticCalculator.add(1,2);
        System.out.println("result :" + result);

        result = arithmeticCalculator.div(1000,10);
        System.out.println("result :" + result);

    }
}
