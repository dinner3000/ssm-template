package com.dinner3000.springmvc.advice;

import com.dinner3000.springmvc.exception.AjaxException;
import com.dinner3000.springmvc.model.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice(basePackages = {"com.dinner3000.springmvc.controller"})
public class WebControllerAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

/*
    @ModelAttribute
    public User newUser() {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return new User();
    }
*/

/*    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(Exception e){
        logger.debug("###MyControllerAdvice - handleException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return response;
    }

    //For wrongly submitting form data to a @RequestBody controller
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        logger.debug("###MyControllerAdvice - handleHttpMediaTypeNotSupportedException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return response;
    }

    @ExceptionHandler(AjaxException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleAjaxException(AjaxException e){
        logger.debug("###MyControllerAdvice - handleException()");
        AjaxResponse response = new AjaxResponse(e.getCode(), e.getMessage());
        return response;
    }

    //For
    // 1. Wrongly submitting serialized (json/xml) data
    // 2. Submitting invalid form data
    // to a non-@RequestBody controller
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleBindException(BindException e){
        logger.debug("###MyControllerAdvice - handleBindException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }

    //For submitting invalid (json/xml) data to a controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.debug("###MyControllerAdvice - handleMethodArgumentNotValidException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }

    //For submitting invalid (json/xml) data to a controller
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleConstraintViolationException(ConstraintViolationException e){
        logger.debug("###MyControllerAdvice - handleMethodArgumentNotValidException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return response;
    }
}
