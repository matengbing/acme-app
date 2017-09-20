package com.acme.app.controller;

import java.net.ConnectException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.api.response.ResponseBean;

/**
 * 全局的异常处理类
 * @author YL.Z
 *
 * @date 2017年4月1日 下午10:05:35
 */
@ControllerAdvice(annotations={RestController.class,Controller.class})
public class SpringExceptionHandle {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);
	/**
	 * 请求参数类型错误异常的捕获
	 * @param
	 * @return
	 */
	@ExceptionHandler(value={BindException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ResponseBean<String> badRequest(BindException e){
		logger.error("occurs error when execute method ,message {}",e.getMessage());
		return new ResponseBean<>(false, AcmeResponseEnums.BAD_REQUEST);
	}
	/**
	 * mybatis未绑定异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindingException.class)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseBean<String> mybatis(Exception e){
		logger.error("occurs error when execute method ,message {}",e.getMessage());
		return new ResponseBean<>(false,AcmeResponseEnums.BOUND_STATEMENT_NOT_FOUNT);
	}
	/**
	 * 自定义异常的捕获
	 * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value={AcmeRuntimeException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> ResponseBean<T> sendError(AcmeRuntimeException exception,HttpServletRequest request){
		String requestURI = request.getRequestURI();
		logger.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMessage());
		return new ResponseBean<>(false,exception.getCode(),exception.getMsg());
	}
	/**
	 * 数据库操作出现异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value={SQLException.class,DataAccessException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseBean<String> systemError(Exception e){
		logger.error("occurs error when execute method ,message {}",e.getMessage());
		return new ResponseBean<>(false, AcmeResponseEnums.DATABASE_ERROR);
	}
	/**
	 * 网络连接失败！
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value={ConnectException.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseBean<String> connect(Exception e){
		logger.error("occurs error when execute method ,message {}",e.getMessage());
		return new ResponseBean<>(false, AcmeResponseEnums.CONNECTION_ERROR);
	}
	
	@ExceptionHandler(value={Exception.class})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
	public ResponseBean<String> notAllowed(Exception e){
		logger.error("occurs error when execute method ,message {}",e.getMessage());
		return new ResponseBean<>(false, AcmeResponseEnums.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseBean<String> illegalArgument(IllegalArgumentException exception){
		return new ResponseBean<>(false,AcmeResponseEnums.ILLEGAL_ARGUMENT);
	}
	
}
