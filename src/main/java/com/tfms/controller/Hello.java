package com.tfms.controller;

import com.tfms.dao.TestDao;
import com.tfms.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public String testHello(){

        System.out.println("成功");

        System.out.println(testService.testDao());

        System.out.println(testService.testDao2());

        return "success";
    }
}
