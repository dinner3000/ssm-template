package com.dinner3000.springmvc.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        System.out.println("###JsonResponseBodyAdvice - supports()");
        return true;
    }

    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("###JsonResponseBodyAdvice - beforeBodyWrite()");
        HttpHeaders headers = serverHttpRequest.getHeaders();
        return o;
    }


}
