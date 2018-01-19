package com.atguigu.spring2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by miaomiao on 18-1-19.
 */
public class ArithmeticCalculatorProxy {

    ArithmeticCalculator target;

    public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;

        //代理对象是由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /*
            * method :正在被调用的方法
            * args：调用方法时，传入的参数
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method " + methodName + " begins with" + Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target,args);
                //日志
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
