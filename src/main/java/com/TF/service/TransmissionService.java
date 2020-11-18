package com.TF.service;

import com.TF.model.Transmission;

import java.util.List;

/**
 * @author ZhaoJiaLin
 * @date 2020-11-18 14:42
 * @description：传输Service
 */
public interface TransmissionService {
    /**
     * description: 条件查询
     * @Author ZhaoJiaLin
     * @Date 18:43 2020/11/15
     * @param transmission
     * @return java.util.List<com.TF.model.Transmission>
     **/
    List<Transmission> selectByParam(Transmission transmission);

    /**
     * description:新增
     * @Author ZhaoJiaLin
     * @Date 14:44 2020/11/18
     * @param transmission
     * @return int
     **/
    int insert(Transmission transmission);
    /**
     * description:
     * @Author ZhaoJiaLin
     * @Date 15:01 2020/11/18
     * @param transmission
     * @return
     **/
    int update(Transmission transmission);
    /**
     * description:
     * @Author ZhaoJiaLin
     * @Date 15:02 2020/11/18
     * @param transmission
     * @return
     **/
    int delete(Transmission transmission);
}
