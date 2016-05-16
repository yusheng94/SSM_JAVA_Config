package com.iboxpay.conf;

import java.io.IOException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
* Comments:  mybatis相关配置                                           
* Author：        zengbo                
* Create Date： 2016-3-20 
* Version:    1.0.0                     
*/ 
@Configuration
// 启用注解事务管理，使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Import({ DataSourceConfig.class,DruidConfig.class})
public class DaoConfig {
	private static final Logger logger = LoggerFactory.getLogger(DaoConfig.class);
	@Resource(name = "dataSource")
	private DataSource dataSource;

	/*
	 * 扫描Mapper映射文件
	 * 加载mybatis缓存配置
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
		logger.info("sqlSessionFactory");
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath*:*Mapper.xml"));
		bean.setConfigLocation(resolver.getResource("classpath:mybatis-env-setting.xml"));
		bean.setDataSource(dataSource);
		return bean;
	}

	/*
	 * 事务管理
	 */
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() {
		logger.info("transactionManager");
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

}
