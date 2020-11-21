package com.tfms.dao.user;

import com.tfms.model.SysUser;

public interface UserDao {

    /**
     * 查找用户
     * @param username
     * @return
     */
    public SysUser findByUserName(String username);

    /**
     * 注册用户
     */
    public int insertByUserNamePassWord(SysUser sysUser);
}
