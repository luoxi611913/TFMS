package com.tfms.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis dao扫描类
 */
@Configuration
public class MybatisDaoConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setBasePackage("com.tfms.config.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");

        return mapperScannerConfigurer;
    }
}
