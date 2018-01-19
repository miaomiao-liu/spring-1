package com.atguigu.spring2;


/**
 * Created by miaomiao on 18-1-19.
 */
public class Main {
    public static void main(String[] args) {

//        ArithmeticCalculator arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorProxy(target).getLoggingProxy();

        int result = proxy.add(1,2);
        System.out.println("-->" + result);

        result= proxy.div(4,2);
        System.out.println("-->" + result);
    }
}
