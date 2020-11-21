package com.tfms.controller.User;

import com.tfms.model.SysUser;
import com.tfms.service.user.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserRegistController {

    @Autowired
    UserRegistService userRegistService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/regist")
    public String regist(){

        SysUser user = new SysUser();

        user.setUsername("admin1");
        user.setPassword(passwordEncoder.encode("test123"));

        userRegistService.userRegist(user);

        return "/top/top";
    }
}
