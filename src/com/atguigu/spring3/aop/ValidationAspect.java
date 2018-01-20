package com.atguigu.spring3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 验证通知
 * Created by miaomiao on 18-1-20.
 */
@Order(1)  //指定切面优先级 ，值越小优先级越高
@Aspect
@Component
public class ValidationAspect {

    @Before("execution(public int com.atguigu.spring3.aop.ArithmeticCalculator.*(..))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate :" + Arrays.asList(joinPoint.getArgs()));
    }


}
