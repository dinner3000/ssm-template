package com.dinner3000.springmvc.controller;

import com.dinner3000.model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("getList")
    public @ResponseBody Object getList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("d");
        list.add("c");

        return list;
    }

    @RequestMapping("getInfo")
    public @ResponseBody Object getInfo(){
        System.out.println("###DefaultController - getInfo()");
        return new Info();
    }


}
