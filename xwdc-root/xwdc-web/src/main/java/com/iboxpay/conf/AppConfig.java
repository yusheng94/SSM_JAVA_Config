package com.iboxpay.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;


/** 
* Comments:                                             
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Configuration  
@ComponentScan(basePackages = "com.xwdc", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })  
@Import({MybatisConfig.class,MsgConfig.class}) 
public class AppConfig {

}
