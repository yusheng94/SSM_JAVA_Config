package com.iboxpay.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/** 
* Comments:  资源文件的扫描                                      
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Configuration
public class MsgConfig {
	private static final Logger logger = LoggerFactory.getLogger(MsgConfig.class);
	
	@Bean(name = { "msg" })
	public static PropertiesFactoryBean mapper() {
		logger.info("msg");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("msg.properties"));
		return bean;
	}
	
	@Bean(name = { "url" })
	public static PropertiesFactoryBean URLMapper() {
		logger.info("url");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("URL.properties"));
		return bean;
	}
	@Bean(name = { "error" })
	public static PropertiesFactoryBean errorMapper() {
		logger.info("error");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("error.properties"));
		return bean;
	}
	@Bean(name = { "WorkDay" })
	public static PropertiesFactoryBean workDayMapper() {
		logger.info("WorkDay");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("WorkDay.properties"));
		return bean;
	}
	@Bean(name = { "BookData" })
	public static PropertiesFactoryBean bookDataMapper() {
		logger.info("BookData");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("BookData.properties"));
		return bean;
	}
	@Bean(name = { "BookCountInfo" })
	public static PropertiesFactoryBean bookCountInfoMapper() {
		logger.info("BookCountInfo");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("BookCountInfo.properties"));
		return bean;
	}
	@Bean(name = { "cancleAppointment" })
	public static PropertiesFactoryBean cancleAppointmentMapper() {
		logger.info("cancleAppointment");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("cancleAppointment.properties"));
		return bean;
	}
	@Bean(name = { "goCancle" })
	public static PropertiesFactoryBean goCancleMapper() {
		logger.info("goCancle");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("goCancle.properties"));
		return bean;
	}
	@Bean(name = { "applyInfo" })
	public static PropertiesFactoryBean ApplyInfoMapper() {
		logger.info("applyInfo");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocations(new ClassPathResource("ApplyInfo.properties"));
		return bean;
	}

}
