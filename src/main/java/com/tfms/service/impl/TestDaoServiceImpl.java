package com.tfms.service.impl;

import com.tfms.dao.TestDao;
import com.tfms.service.TestDaoService;
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
