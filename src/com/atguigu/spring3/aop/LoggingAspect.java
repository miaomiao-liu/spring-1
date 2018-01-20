package com.atguigu.spring3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by miaomiao on 18-1-20.
 */
@Aspect
@Component
public class LoggingAspect {


//    /**
//     * 将该方法声明为一个前置通知：在目标方法执行之前执行
//     * @param joinPoint
//     */
//    @Before("execution(public int com.atguigu.spring3.aop.*.*(..))")
//    public void beforeMethod(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("The method " + methodName + " begins with " + args);
//    }
//
//    /**
//     * 后置通知：在目标方法执行后（无论是否发生异常）执行的通知
//     * 在后置通知中不能访问目标方法执行的结果（需要在返回通知中访问）
//     * @param joinPoint
//     */
//    @After("execution(public int com.atguigu.spring3.aop.*.*(..))")
//    public void afterMethod(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends");
//    }
//
//    /**
//     * 在方法正常结束受执行的代码
//     * 返回通知可以访问到方法的返回值
//     * @param joinPoint
//     * @param result
//     */
//    @AfterReturning(value = "execution(public int com.atguigu.spring3.aop.*.*(..))",
//    returning = "result")
//    public void afterReturning(JoinPoint joinPoint,Object result){
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " ends with " + result);
//    }
//
//    /**
//     * 在目标方法出现异常时会执行的通知
//     * 可以访问到异常对象，且可以指定在出现特定异常时执行
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(value = "execution(public int com.atguigu.spring3.aop.*.*(..))",
//    throwing = "e")
//    public void afterThrowing(JoinPoint joinPoint,Exception e){
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("The method " + methodName + " occurs excetion " + e);
//    }


    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程
     * 必须有返回值，即为目标方法的返回值
     * @param pjd
     * @return
     */
    @Around("execution(public int com.atguigu.spring3.aop.*.*(..))")
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
