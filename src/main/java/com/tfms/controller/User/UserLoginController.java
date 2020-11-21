package com.tfms.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }

    @RequestMapping("/loginsuccess")
    public String loginSuccess(){
        System.out.println("登陆成功");
        return "/top/top";
    }
}
