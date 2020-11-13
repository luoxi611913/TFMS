package com.TF.service.impl;

import com.TF.dao.TestDao;
import com.TF.service.intf.TestDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDaoServiceImpl implements TestDaoService {

    @Autowired
    TestDao testDao;

    @Override
    public int userCount() {
        return testDao.userCount();
    }
}
