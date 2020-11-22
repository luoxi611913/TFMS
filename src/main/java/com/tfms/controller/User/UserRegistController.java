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
     * 账户存在验证
     * @return
     */
    @RequestMapping("/usernameconfirm")
    @ResponseBody
    public String usernameConfirm(String username){

        System.out.println("username"+username);

        if(username.equals("luoxi611")){
            return "已存在";
        }

        return "可用";
    }

    /**
     * 执行注册
     * @param user
     * @param response
     * @return
     */
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
