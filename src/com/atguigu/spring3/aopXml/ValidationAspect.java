package com.atguigu.spring3.aopXml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * 验证通知
 * Created by miaomiao on 18-1-20.
 */
public class ValidationAspect {

    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate :" + Arrays.asList(joinPoint.getArgs()));
    }


}
