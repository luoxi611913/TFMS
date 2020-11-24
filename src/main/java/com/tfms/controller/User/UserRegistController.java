package com.tfms.controller.User;

import com.tfms.model.SysMsg;
import com.tfms.model.SysUser;
import com.tfms.service.user.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class UserRegistController {

    @Autowired
    UserRegistService userRegistService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 用户名重复验证
     * @return
     */
    @RequestMapping("/usernameconfirm")
    @ResponseBody
    public String usernameConfirm(String username){

        System.out.println("username"+username);
        //调用service查询用户名是否重复
        SysUser byUsername = userRegistService.findByUsername(username);
        if(byUsername!=null){
            return "用户名已存在";
        }else {
            return "用户名可用";
        }
    }

    /**
     * 执行注册
     * @param user
     * @return
     */
    @RequestMapping("/regist")
    public String regist(SysUser user){
        //用户名没有被注册，执行添加操作
        userRegistService.userRegist(user);
        return "register/register_ok";
    }
}
