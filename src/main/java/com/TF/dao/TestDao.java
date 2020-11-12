package com.TF.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

public interface TestDao {
        /*
        查询user表总数
         */
        public int userCount();

        @Select("SELECT count(*) FROM user")
        public int selectByConf();
}
