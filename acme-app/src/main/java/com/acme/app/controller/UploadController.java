/*package com.acme.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.api.utils.Constant;
import com.acme.app.model.user.User;
import com.acme.app.service.user.UserService;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


*//**
 * 
 * @author YL.Z
 *
 * @date 2017年1月24日 下午1:55:48
 *//*
@Controller
public class UploadController {
	
	private static final Logger logger= LoggerFactory.getLogger(UploadController.class);
	
	@Resource
	private UserService userService;
	
	*//**
	 * 头像的上传
	 * @param request
	 * @throws Exception、
	 *//*
	@RequestMapping(value={"upload/avatar"})
	@ResponseBody
	public ResponseBean<String> uploadAndroidAvatar(HttpServletRequest request)throws Exception
	{
		//必须获得用户的id
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		MultipartFile pic = null ;
		for (Entry<String, MultipartFile> entry : entrySet) {
			pic= entry.getValue();
		}
		try {
			String path = upload(pic,200,200,false,null);
			String url =Constant.UPLOAD_PATH+path;
			return new ResponseBean<String>(true,url, AcmeResponseEnums.FILEUPLOAD_SUCCESS);
		} catch (Exception e) {
			logger.info("occurs error when excute method=uploadAndroidAvatar, error {}",e.getMessage());
			return new ResponseBean<String>(false,AcmeResponseEnums.SYSTEM_ERROR);
		}
	}
	@RequestMapping(value={"upload/uploadImage"})
	@ResponseBody
	public ResponseBean<String> uploadImage(HttpServletRequest request){
		User userInfo=(User)request.getSession().getAttribute(Constant.ACTIVE_USER);
		if (userInfo==null) {
			return new ResponseBean<String>(false, AcmeResponseEnums.NOLOGIN);
		}
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		MultipartFile pic = null ;
		for (Entry<String, MultipartFile> entry : entrySet) {
			pic= entry.getValue();
		}
		String path = upload(pic,200,200,false,null);
		String url =Constant.UPLOAD_PATH+path;
		return new ResponseBean<String>(true, url,AcmeResponseEnums.SUCCESS_OPTION);
	}
	*//**
	 * 上传
	 * 
	 * @param pi
	 * @param w 
	 * @param h
	 * @param isAdd 是否添加水印
	 * @return
	 *//*
	private String upload(MultipartFile pic,int w,int h,boolean isAdd,String mark) {
		String filename = pic.getOriginalFilename();
		// 获得图片的扩展名：
		String ext = FilenameUtils.getExtension(filename);
		// 随机的产生图片名:
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String fm = format.format(new Date());
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			fm += random.nextInt(10);
		}
		String path = fm + "." + ext;// 这个路径保存到数据库中
		String url = Constant.UPLOAD_PATH + path;
		Client client = new Client();

		WebResource resource = client.resource(url);

		try {
			ImgCompress demo=new ImgCompress(pic);
			JPEGImageEncoder encoder = demo.resizeFix(w,h,isAdd,mark);
			OutputStream out = encoder.getOutputStream();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
			bout=(ByteArrayOutputStream) out;
			byte[] byteArray = bout.toByteArray();
			resource.put(String.class,byteArray);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return path;
	}


}
*/