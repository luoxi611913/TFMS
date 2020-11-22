package com.tfms.service.user;

import com.tfms.model.SysUser;

public interface UserRegistService {
    public SysUser findByUsername(String username);

    /*
    用户注册
     */
    public int userRegist(SysUser sysUser);
}
