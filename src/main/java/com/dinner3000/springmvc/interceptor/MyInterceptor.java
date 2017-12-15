package com.dinner3000.springmvc.interceptor;


import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class MyInterceptor implements WebRequestInterceptor {
    public void preHandle(WebRequest webRequest) throws Exception {

        System.out.println("###MyInterceptor - preHandle()");
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

        System.out.println("###MyInterceptor - postHandle()");
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

        System.out.println("###MyInterceptor - afterCompletion()");
    }
}
