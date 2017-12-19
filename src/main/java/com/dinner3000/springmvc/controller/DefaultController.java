package com.dinner3000.springmvc.controller;

import com.dinner3000.model.DefaultModel;
import com.dinner3000.service.DefaultService;
import com.dinner3000.springmvc.model.AjaxResponse;
import com.dinner3000.springmvc.model.DefaultForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/")
public class DefaultController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DefaultService defaultService;

    @RequestMapping("getList")
    @ResponseBody
    public Object getList(){
        logger.info("###DefaultController - getList()");
        return defaultService.getList();
    }

    @RequestMapping("queryList")
    @ResponseBody
    public Object queryList(){
        logger.info("###DefaultController - queryList()");
        return defaultService.queryList();
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Object getInfo(){
        logger.info("###DefaultController - getInfo()");
        return defaultService.getInfo();
    }

    @RequestMapping("submitForm1")
    @ResponseBody
    public Object submitForm1(@Valid DefaultForm form){

        logger.info("###DefaultController - submitForm1()");

        AjaxResponse response = new AjaxResponse();

        DefaultModel model = DefaultModel.ConvertFromDefaultForm(form);
        Set<ConstraintViolation<DefaultModel>> constraintViolations =
                validator.validate( model );
        if(constraintViolations.size()>0){
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            response.setData(constraintViolations.toString());
        }else {
            response.setData(model);
        }
        return response;
    }

    @RequestMapping("submitForm2")
    @ResponseBody
    public Object submitForm2(@Valid @RequestBody DefaultForm form){

        logger.info("###DefaultController - submitForm2()");

        AjaxResponse response = new AjaxResponse();

        DefaultModel model = DefaultModel.ConvertFromDefaultForm(form);
        Set<ConstraintViolation<DefaultModel>> constraintViolations =
                validator.validate( model );
        if(constraintViolations.size()>0){
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            response.setData(constraintViolations.toString());
        }else {
            response.setData(model);
        }
        return response;
    }

}
