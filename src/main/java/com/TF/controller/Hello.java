package com.TF.controller;

import com.TF.dao.TestDao;
import com.TF.service.TestDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @Autowired
    TestDaoService testDaoService;

    @Autowired
    TestDao testDao;

    @RequestMapping("/hello")
    public String helloTest(){

        testDaoService.userCount();

        System.out.println(testDaoService.userCount());

        System.out.println("成功!");


        System.out.println( testDao.selectByConf());

        return "success";
    }

    @RequestMapping("/testThy")
    public String index(Model model) {
        model.addAttribute("name","测试模板引擎");
        return "testThymeleaf";
    }
}
