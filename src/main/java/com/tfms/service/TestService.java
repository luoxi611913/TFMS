package com.tfms.service;

import com.tfms.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class TestService {

    @Autowired
    private TestDao testDao;

    /**
     * 测试注解Sql
     * @return
     */
    public int testDao(){
        return testDao.testSelect();
    }

    /**
     * 测试配置文件Sql
     * @return
     */
    public int testDao2(){
        return testDao.testSelect2();
    }
}
