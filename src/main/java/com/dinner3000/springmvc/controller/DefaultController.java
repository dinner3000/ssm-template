package com.dinner3000.springmvc.controller;

import com.dinner3000.model.DefaultModel;
import com.dinner3000.service.impl.DefaultService;
import com.dinner3000.springmvc.model.AjaxResponse;
import com.dinner3000.springmvc.model.DefaultForm;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/")
@Validated
public class DefaultController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DefaultService defaultService;

    @RequestMapping("getList")
    public Object getList() {
        logger.info("###DefaultController - getList()");
        return defaultService.getList();
    }

    @RequestMapping("queryList")
    public Object queryList() {
        logger.info("###DefaultController - queryList()");
        return defaultService.queryList();
    }

    @RequestMapping("getInfo")
    public Object getInfo() {
        logger.info("###DefaultController - getInfo()");
        return defaultService.getInfo();
    }

    @RequestMapping("submitForm1")
    public Object submitForm1(@Valid DefaultForm form) {

        logger.info("###DefaultController - submitForm1()");

        DefaultModel model = DefaultModel.ConvertFromDefaultForm(form);

        return model;
    }

    @RequestMapping("submitForm2")
    public Object submitForm2(@NotNull Integer a, @NotEmpty String b) {

        logger.info("###DefaultController - submitForm1()");

        return new Object[]{a, b};
    }

}
