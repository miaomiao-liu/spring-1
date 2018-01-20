package com.atguigu.spring3.aopXml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

/**
 * Created by miaomiao on 18-1-20.
 */
public class LoggingAspect {


    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs excetion " + e);
    }


    public Object aroundMethod(ProceedingJoinPoint pjd){

        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("The method " + methodName + " occurs excetion " + throwable);
        }

        //后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }

}
