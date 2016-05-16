package com.iboxpay.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;

/** 
* Comments:  web.xml                                           
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Order(1)
public class CommonInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		/*
		 * 加载日志文件、添加Listener
		 */
		servletContext.setInitParameter("logbackConfigLocation",
				"classpath:logback.xml");
		servletContext.addListener(LogbackConfigListener.class);

		/*
		 * 配置druid servlet
		 */
		javax.servlet.ServletRegistration.Dynamic dynamic = servletContext.addServlet("DruidStatView",
				StatViewServlet.class);
		dynamic.addMapping("/druid/*");
		dynamic.setInitParameter("loginUsername", "admin1");
		dynamic.setInitParameter("loginPassword", "admin");
		
		/*
		 * 配置druid filter
		 */
		javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("DruidWebStatFilter", WebStatFilter.class);
		filter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filter.addMappingForUrlPatterns(null, true, "/*");
	}
}
