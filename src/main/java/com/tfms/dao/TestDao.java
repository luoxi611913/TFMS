package com.tfms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface TestDao {

    @Select("SELECT COUNT(1) FROM sysuser")
    public int testSelect();

    public int testSelect2();
}
