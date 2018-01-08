package com.dinner3000.springmvc.aop;

import com.dinner3000.springmvc.model.WebControllerLogRecord;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WebControllerLogAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson = new Gson();

    @Autowired
    private WebControllerLogRecord logRecord;

    public void before(JoinPoint joinPoint){
        logger.debug("###WebControllerLogAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###WebControllerLogAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###WebControllerLogAdvice - around() - before");

        Object retVal = proceedingJoinPoint.proceed();

        logRecord.loadContextInfo(proceedingJoinPoint);
        logRecord.setResponse(retVal);

        logger.info(gson.toJson(logRecord));

        logger.debug("###WebControllerLogAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###WebControllerLogAdvice - afterReturning()");
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###WebControllerLogAdvice - afterThrowing()");
    }
}
