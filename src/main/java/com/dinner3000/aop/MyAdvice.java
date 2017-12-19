package com.dinner3000.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class MyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void before(JoinPoint joinPoint){
        logger.debug("###MyAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###MyAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###MyAdvice - around() - before");
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Object retVal = proceedingJoinPoint.proceed();

        logger.debug("###MyAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###MyAdvice - afterReturning()");
    }
}
