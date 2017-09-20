package com.acme.app.context;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


/**
 * MySQL获取数据源链接
 * @author 10057738
 *
 */
@Configuration
@PropertySource("classpath:/mysqldb.properties")
public class MySQLDBConfiguration {
	private static Logger log=LoggerFactory.getLogger(MySQLDBConfiguration.class);
	
	@Value("${db.driver}")
	private String driver;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;
	
	@Value("${minPoolSize}")
	private int minPoolSize;
	
	@Value("${maxPoolSize}")
	private int maxPoolSize;
	
	@Value("${maxIdleTime}")
	private int maxIdleTime;
	
	@Value("${acquireIncrement}")
	private int acquireIncrement;
	
	@Value("${maxStatements}")
	private int maxStatements;
	
	@Value("${initialPoolSize}")
	private int initialPoolSize;
	
	@Value("${idleConnectionTestPeriod}")
	private int idleConnectionTestPeriod;
	
	@Value("${acquireRetryAttempts}")
	private int acquireRetryAttempts;
	
	@Value("${breakAfterAcquireFailure}")
	private boolean breakAfterAcquireFailure;
	
	@Value("${testConnectionOnCheckout}")
	private boolean testConnectionOnCheckout;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		
		log.info("init dataSource start");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try
		{
			dataSource.setDriverClass(driver);
			dataSource.setJdbcUrl(url);
			dataSource.setUser(username);
			dataSource.setPassword(password);
			dataSource.setMinPoolSize(minPoolSize);
			dataSource.setMaxPoolSize(maxPoolSize);
			dataSource.setAcquireIncrement(acquireIncrement);
			dataSource.setMaxIdleTime(maxIdleTime);
			dataSource.setMaxStatements(maxStatements);
			dataSource.setInitialPoolSize(initialPoolSize);
			dataSource.setAcquireRetryAttempts(acquireRetryAttempts);
			dataSource.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
			dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout);
		}catch(Throwable th)
		{
			log.error("occurs error when init datasource message = {}",th.getMessage());
		}	
		log.info("init dataSource end");
		
		return dataSource;
	}
}
