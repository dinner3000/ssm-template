package com.dinner3000.springmvc.aop;

import com.dinner3000.springmvc.model.AjaxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebControllerResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void before(JoinPoint joinPoint){
        logger.debug("###WebControllerResponseBodyAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###WebControllerResponseBodyAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###WebControllerResponseBodyAdvice - around() - before");

        Object retVal = proceedingJoinPoint.proceed();

        if (!(retVal instanceof AjaxResponse)) {
            AjaxResponse res = new AjaxResponse();
            res.setData(retVal);
            retVal = res;
        }

        logger.debug("###WebControllerResponseBodyAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###WebControllerResponseBodyAdvice - afterReturning()");
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###WebControllerResponseBodyAdvice - afterThrowing()");
    }
}
