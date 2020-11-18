package com.TF.service.impl;

import com.TF.dao.TransmissionDao;
import com.TF.model.Transmission;
import com.TF.service.TransmissionService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhaoJiaLin
 * @date 2020-11-18 14:42
 * @description：传输service
 */
@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    private TransmissionDao transmissionDao;


    @Override
    public List<Transmission> selectByParam(Transmission transmission) {
        return transmissionDao.selectByParam(transmission);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Transmission transmission) {
        //数据库不存在新增
        Transmission selectParam = new Transmission();
        selectParam.setStartUser(transmission.getStartUser());
        selectParam.setJumperPort(transmission.getJumperPort());
        selectParam.setChannelCode(transmission.getChannelCode());
        List<Transmission> transmissions = transmissionDao.selectByParam(selectParam);
        if (transmissions.size() == 0) {
            return transmissionDao.insert(transmission);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Transmission transmission) {
        //查到唯一一条修改
        Transmission selectParam = new Transmission();
        selectParam.setStartUser(transmission.getStartUser());
        selectParam.setJumperPort(transmission.getJumperPort());
        selectParam.setChannelCode(transmission.getChannelCode());
        List<Transmission> transmissions = transmissionDao.selectByParam(selectParam);
        if (transmissions.size() == 1) {
            return transmissionDao.update(transmission);
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Transmission transmission) {
        //查到唯一一条删除
        Transmission selectParam = new Transmission();
        selectParam.setStartUser(transmission.getStartUser());
        selectParam.setJumperPort(transmission.getJumperPort());
        selectParam.setChannelCode(transmission.getChannelCode());
        List<Transmission> transmissions = transmissionDao.selectByParam(selectParam);
        if (transmissions.size() == 1) {
            return transmissionDao.delete(transmission);
        }
        return 0;
    }
}
