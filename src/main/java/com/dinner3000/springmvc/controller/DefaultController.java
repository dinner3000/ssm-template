package com.dinner3000.springmvc.controller;

import com.dinner3000.model.Info;
import com.dinner3000.service.DefaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DefaultController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DefaultService defaultService;

    @RequestMapping("getList")
    public @ResponseBody Object getList(){
        logger.info("###DefaultController - getList()");
        return defaultService.getList();
    }

    @RequestMapping("queryList")
    public @ResponseBody Object queryList(){
        logger.info("###DefaultController - queryList()");
        return defaultService.queryList();
    }

    @RequestMapping("getInfo")
    public @ResponseBody Object getInfo(){
        logger.info("###DefaultController - getInfo()");
        return defaultService.getInfo();
    }


}
