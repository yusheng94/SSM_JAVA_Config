package com.iboxpay.conf;

import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/** 
* Comments:  初始化数据源                                          
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/
//加载资源文件  
@Configuration
public class DataSourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	/*
	 * 绑定资源属性
	 */
	@Resource(name = "db")
	private Map<String, String> map;

	@Bean(name = { "db" })
	public static PropertiesFactoryBean mapper() {
		logger.info("db");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("db.properties"));
		return bean;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		logger.info("dataSource");
		logger.info("url = " + map.get("url"));
		logger.info("username = " + map.get("username"));
		logger.info("password = " + map.get("password"));
		try {
			DataSource dataSource = DruidDataSourceFactory.createDataSource(map);
			return dataSource;
		} catch (Exception e) {
			logger.error("数据库初始化错误，请查看db.properties", e);
		}
		logger.error("数据库初始化错误，请查看db.properties");
		return null;
	}
}