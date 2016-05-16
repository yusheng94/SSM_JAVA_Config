package com.iboxpay.conf;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/** 
* Comments:                                             
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Configuration
@Import({DaoConfig.class})
public class MybatisConfig {
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
	/*
	 * 扫描dao
	 */
	@Bean(name = "mybatisDao")
	public MapperScannerConfigurer mybatisDAO() {
		logger.info("mybatisDao");
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.xwdc.dao");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScannerConfigurer;
	}
}
