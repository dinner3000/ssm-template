package com.dinner3000.springmvc.controller;

import com.dinner3000.springmvc.model.AjaxResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class BaseController {

    protected static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(Exception e){
        AjaxResponse response = new AjaxResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return response;
    }

    //For
    // 1. Wrongly submitting serialized (json/xml) data
    // 2. Submitting invalid form data
    // to a non-@RequestBody controller
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(BindException e){
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }

    //For wrongly submitting form data to a @RequestBody controller
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(HttpMediaTypeNotSupportedException e){
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return response;
    }

    //For submitting invalid (json/xml) data to a controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }
}
