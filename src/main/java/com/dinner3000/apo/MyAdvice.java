package com.dinner3000.apo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class MyAdvice {

    public void before(JoinPoint joinPoint){
        System.out.println("###MyAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        System.out.println("###MyAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("###MyAdvice - around() - before");
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Object retVal = proceedingJoinPoint.proceed();

        System.out.println("###MyAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        System.out.println("###MyAdvice - afterReturning()");
    }
}
