package com.acme.app.controller.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;




import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.api.utils.Constant;
import com.acme.api.utils.UserType;
import com.acme.app.dto.user.UserDto;
import com.acme.app.model.user.User;
import com.acme.app.service.user.UserService;
@Controller
@RequestMapping(value="/file",method=RequestMethod.POST)
public class FileUploadConstroller {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	@ResponseBody	
	public ResponseBean<?> upload(@RequestParam CommonsMultipartFile file,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
		UserDto user=(UserDto) session.getAttribute(UserType.SESSIONUSER);
		if(user==null){
			return new ResponseBean<String>(false, AcmeResponseEnums.NOLOGIN);
		}
		String type=FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(type);
		String filename = user.getId()+"_"+System.currentTimeMillis() +"."+ type;
		String realPathString=session.getServletContext().getRealPath("");
		System.out.println(realPathString);
        File destFile = new File(realPathString+Constant.UPLOAD_PATH+filename); 
       /**
        * 父目录不存在时先创建父级目录
        * */
        if(!destFile.getParentFile().exists()){
        	destFile.getParentFile().mkdirs();
        }
       // file.transferTo(destFile);
        //图片压缩处理
        Thumbnails.of(file.getInputStream())   
        .size(200, 200)  
        .toFile(destFile);  
        userService.updateIconById(user.getId(), destFile.getAbsolutePath());
		return new ResponseBean<String>(true, destFile.getAbsolutePath(),AcmeResponseEnums.SUCCESS_OPTION);
	}
	
	
}
