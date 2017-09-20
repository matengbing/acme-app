package com.acme.app.context;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * web应用初始化
 * 该类会在容器启动之时自动运行
 * @author 10057738
 *
 */
public class WebInitalizer implements WebApplicationInitializer{
	private static  Logger logger=LoggerFactory.getLogger(WebInitalizer.class);
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//创建spring的上下文：
		AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringRootConfig.class);
		//管理生命周期：
		servletContext.addListener(new ContextLoaderListener(rootContext));;
		//字符编码过滤器：
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(Boolean.TRUE);
		//设置ajax请求方式返回的数据格式为JSON
		FilterRegistration.Dynamic addFilter = servletContext.addFilter("characterEncodingFilter",encodingFilter);
	
		//设置过滤的地址：
		addFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class),false, "/");
		//用户过滤
//		FilterRegistration.Dynamic ssoAuthenticationFilter = servletContext.addFilter("SSO Authentication Filter", new DubboOAuthFilter());
//		ssoAuthenticationFilter.addMappingForUrlPatterns(null,false,"*.htm");

		//配置Spring的上下文：
		AnnotationConfigWebApplicationContext dispatcherContext=new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(SpringMVCConfig.class);
		
		//注册SpringMVC的分发路径
		
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet",new DispatcherServlet(dispatcherContext));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
		/*
		 * 不再需要这个===》》》》web.xml文件
		 * 
		 * 
		 * 
		 * 
		 */
		logger.info("success load..");
	}
	
}
