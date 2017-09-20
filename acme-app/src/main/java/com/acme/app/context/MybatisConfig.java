package com.acme.app.context;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Mybatis配置
 * @author 10057738
 *
 */
@Configuration
@Import(MySQLDBConfiguration.class)
@MapperScan("com.acme.app.mapper")
@EnableTransactionManagement
public class MybatisConfig {
	private static Logger log = org.slf4j.LoggerFactory.getLogger(MybatisConfig.class);
	
	@Resource
	private DataSource dataSource;
	
	private static String CONFIGURE_FILE="mybatis-config.xml";
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		org.springframework.core.io.Resource configuration = new ClassPathResource(CONFIGURE_FILE);
		bean.setConfigLocation(configuration);
		log.info("set sql sessionFactory finished ..");
		SqlSessionFactory factory=null;
		try {
			factory=bean.getObject();
		} catch (Exception e) {
			log.error("mybatis xml load error",e);
		}
		return factory;
	}
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
