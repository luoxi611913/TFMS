package com.tfms.service.user;

import com.tfms.dao.user.UserDao;
import com.tfms.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册用Service
 */
@Service("userRegistService")
public class UserRegistServiceImpl implements UserRegistService{

    @Autowired
    UserDao userDao;

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public int userRegist(SysUser sysUser) {

        return userDao.userRegister(sysUser);

    }
}
