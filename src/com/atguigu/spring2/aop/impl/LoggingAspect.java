package com.atguigu.spring2.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 将该类声明为一个切面：@Component：将该类交给IOC容器管理
 *                    @Aspect：声明为一个切面
 * Created by miaomiao on 18-1-20.
 */
@Aspect
@Component
public class LoggingAspect {

//    将该方法声明为一个前置通知：在目标方法执行之前执行
    @Before("execution(* com.atguigu.spring2.aop.impl.*.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

//    后置通知：在目标方法执行后（无论是否发生异常）执行的通知
//     在后置通知中不能访问目标方法执行的结果（需要在返回通知中访问）
    @After("execution(* com.atguigu.spring2.aop.impl.*.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");

    }
}
