package com.TF.controller;

import com.TF.dao.TestDao;
import com.TF.service.intf.TestDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {

    @Autowired
    TestDaoService testDaoService;

    @Autowired
    TestDao testDao;

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
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
