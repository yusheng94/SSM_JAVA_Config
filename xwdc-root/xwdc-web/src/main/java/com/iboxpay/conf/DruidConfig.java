package com.iboxpay.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
/** 
* Comments:  druid配置                                           
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DruidConfig {

	private static final Logger logger = LoggerFactory
			.getLogger(DruidConfig.class);

	@Bean
	public JdkRegexpMethodPointcut methodPointcut() {
		logger.info("JdkRegexpMethodPointcut");
		JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
		jdkRegexpMethodPointcut.setPatterns("com.xwdc.service.*");
		return jdkRegexpMethodPointcut;
	}
	
	@Bean
	public DruidStatInterceptor interceptor(){
		logger.info("DruidStatInterceptor");
		return new DruidStatInterceptor();
	}
	

	@Bean
	public Advisor jpaRepositoryAdvisor() {
		logger.info("Advisor");
		return new DefaultPointcutAdvisor(methodPointcut(),
				interceptor());
	}

}
