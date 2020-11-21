package com.tfms.security;

import com.tfms.dao.user.UserDao;
import com.tfms.model.SysRole;
import com.tfms.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //重写loadUserByUsername 方法获得 userdetails 类型用户
        //调起用户dao
        SysUser user = userDao.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。用户权限添加到authorities。
        for(SysRole role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
