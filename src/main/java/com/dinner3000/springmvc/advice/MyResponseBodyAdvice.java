package com.dinner3000.springmvc.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice({"com.dinner3000.springmvc.controller"})
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public boolean supports(MethodParameter methodParameter, Class aClass) {
        logger.debug("###MyResponseBodyAdvice - supports()");
        return true;
    }

    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        logger.debug("###MyResponseBodyAdvice - beforeBodyWrite()");
        HttpHeaders headers = serverHttpRequest.getHeaders();
        return o;
    }


}
