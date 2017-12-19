package com.dinner3000.springmvc.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class MyInterceptor implements WebRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void preHandle(WebRequest webRequest) throws Exception {
        logger.debug("###MyInterceptor - preHandle()");
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        logger.debug("###MyInterceptor - postHandle()");
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        logger.debug("###MyInterceptor - afterCompletion()");
    }
}
