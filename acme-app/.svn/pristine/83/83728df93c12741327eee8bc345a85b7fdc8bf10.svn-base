package com.acme.app.context;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * spring上下文的配置
 * @author 10057738
 *
 */
@Configuration
@Import({MySQLDBConfiguration.class,MybatisConfig.class})
@ComponentScan(basePackages={"com.acme.app.service"},excludeFilters={@Filter(Controller.class),@Filter(Configuration.class)})
public class SpringRootConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setQueueCapacity(1000);
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(15);
		executor.setKeepAliveSeconds(5000);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}
//	@Bean
//	public SessionProvider provider(){
//		return new SessionProviderImpl();
//	}
//
//	@Bean
//	public StaticPageService staticPageService() throws IOException {
//		StaticPageServiceImpl staticPageService=new StaticPageServiceImpl();
//		logger.info("get staticPageService instance {}",staticPageService);
//		FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
//		Properties properties=new Properties();
//		properties.put("defaultEncoding", "UTF-8");
//		bean.setFreemarkerSettings(properties);
//		staticPageService.setFreeMarkerConfigurationFactoryBean(bean);
//		return staticPageService;
//	}
}
