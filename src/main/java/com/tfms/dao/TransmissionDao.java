package com.tfms.dao;

import com.tfms.model.Transmission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description：传输
 * @author ZhaoJiaLin
 * @date 2020-11-15 18:05
 */
@Mapper
public interface TransmissionDao {
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
