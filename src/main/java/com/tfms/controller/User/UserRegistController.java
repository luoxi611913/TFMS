package com.tfms.controller.User;

import com.tfms.model.SysMsg;
import com.tfms.model.SysUser;
import com.tfms.service.user.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@RequestMapping("/user")
@Controller
public class UserRegistController {

    @Autowired
    UserRegistService userRegistService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/regist")
    public String regist(SysUser user, HttpServletResponse response){
        //调用service查询该用户名是否被注册
        try {
            SysUser byUsername = userRegistService.findByUsername(user.getUsername());
            if (byUsername==null){
                //用户名没有被注册，执行添加操作
                userRegistService.userRegist(user);
                return "register/register_ok";
            }else {
                //已注册，则回写错误信息
                response.getWriter().write("用户名已重复");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "false";
        }
    }
}
