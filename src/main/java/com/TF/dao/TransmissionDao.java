package com.TF.dao;

import com.TF.model.Transmission;

import java.util.List;

/**
 * @Description：传输
 * @author ZhaoJiaLin
 * @date 2020-11-15 18:05
 */
public interface TransmissionDao {
    /**
     * @Description:
     * @Author ZhaoJiaLin
     * @Date 18:43 2020/11/15
     * @Param transmission
     * @return java.util.List<com.TF.model.Transmission>
     **/
    List<Transmission> selectByParam(Transmission transmission);
}
