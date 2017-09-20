package com.acme.app.context;


import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.acme.api.interceptor.PermissionInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * SpringMVC控制器配置
 * @author 10057738
 *	事务配置注意的地方：
 *	includeFilters={@Filter(Controller.class)},excludeFilters={@Filter(Service.class)}
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)//等效于<aop:aspectj-autoproxy/>
@ComponentScan(basePackages={"com.acme.app.controller","com.acme.app.service","com.acme.app.aspect"}//扫描web包以及service包
,useDefaultFilters=false,includeFilters={@Filter(Controller.class),@Filter(Aspect.class),@Filter(Component.class)},excludeFilters={@Filter(Service.class)})
public class SpringMVCConfig extends WebMvcConfigurerAdapter{
	private static final Logger logger=LoggerFactory.getLogger(SpringMVCConfig.class);
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(permissionInterceptor());
		super.addInterceptors(registry);
	}
	
	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		super.extendHandlerExceptionResolvers(exceptionResolvers);
	}
	/**
	 * 必须注入，此拦截器主要负责的是userKey 的验证。
	 * 保证是用户本身在操作。防止数据被篡改
	 * userKey 验证拦截器
	 * @return
	 */
	@Bean
	public PermissionInterceptor permissionInterceptor(){
		return new PermissionInterceptor();
	}
	/**
	 * 基本配置
	 * 
	 * 配置内容：
	 * 1、
	 * 2、
	 * 3、
	 * @return
	 */
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
		
		RequestMappingHandlerAdapter adapter=new RequestMappingHandlerAdapter();
		
		List<HttpMessageConverter<?>> messageConverters=new ArrayList<>();
		StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<MediaType> mediaTypes=new ArrayList<>();
		mediaTypes.add(MediaType.parseMediaType("application/json;charset=utf-8"));
		mediaTypes.add(MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8"));
		stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		
		//设置支持Json数据处理：
		List<MediaType> jsonSurpportMediaTypes=new ArrayList<>();
		jsonSurpportMediaTypes.add(MediaType.parseMediaType("application/json;charset=utf-8"));
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(jsonSurpportMediaTypes);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ObjectMapper mapper=new ObjectMapper();
		//设置日期格式：
		mapper.setDateFormat(format);
		//输出JSON字符
		
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		
		//忽略一些错误
		
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  //属性没有不报错
		mapper.disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);  //为null不报错
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);	//枚举值转化为字符串
		mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);	//枚举值不匹配为空
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);	//null设置为空字符串""
		logger.info("to json... with null value as empty");
		mappingJackson2HttpMessageConverter.setObjectMapper(mapper);
		
		messageConverters.add(mappingJackson2HttpMessageConverter);
		messageConverters.add(stringHttpMessageConverter);
		
		adapter.setMessageConverters(messageConverters);
		return adapter;
	}
	
	//配置映射的路径
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	/**
	 * 异常出现后到该页面
	 * @return
	 */
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
		Properties properties=new Properties();
		properties.setProperty("code_400","400");
		properties.setProperty("code_500","500");
		exceptionResolver.setStatusCodes(properties);
		exceptionResolver.setDefaultErrorView("error/error");
		return exceptionResolver;
	}
	/**
	 * 查看源码显示需要动态的注入 DefaultServletHttpRequestHandler以用来处理静态资源类似于：*.js,*.css文件以及图片等。
	 * 注入此类会默认的调用容器的Servlet类来处理，
	 * 知名的Servlet容器比如有Tomcat , jetty jboss 等的ServletName都是default
	 * 当没有设置ServletName值时默认的是default.
	 * 目前经测试，此方法注入可以访问到静态的资源文件；
	 * 直接注入的方式比如：
	 *  @Bean
	 * 	public DefaultServletHttpRequestHandler defaultServletHttpRequestHandler(){
	 *		DefaultServletHttpRequestHandler handler=new DefaultServletHttpRequestHandler();
	 *		return handler;
	 *	}
	 * 不能访问到静态的资源文件的，
	 * 只能以下面的方式注入；
	 * @return
	 */
	@Bean
	public DefaultServletHttpRequestHandler defaultServletHttpRequestHandler(){
		DefaultServletHttpRequestHandler handler=(DefaultServletHttpRequestHandler)simpleUrlHandlerMapping().getUrlMap().get("/**");
		return handler;
	}
	/**
	 * 处理路径请求的配置
	 * @return
	 */
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		simpleUrlHandlerMapping.setMappings(mappings);
		simpleUrlHandlerMapping.setOrder(1); // 先执行小的
		DefaultServletHttpRequestHandler handler=new DefaultServletHttpRequestHandler();
		Map<String,DefaultServletHttpRequestHandler> map=new HashMap<>();
		map.put("/**", handler);
		simpleUrlHandlerMapping.setUrlMap(map);
		return simpleUrlHandlerMapping;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(10000025);
		return commonsMultipartResolver;
	}
}
