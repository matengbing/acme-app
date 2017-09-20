/*package com.acme.app.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

*//**
 * @ClassName:     ImgCompress.java
 * @Description:   TODO 
 * 
 * @author         ziyunlong
 * @version        V1.0  
 * @Date           2016-5-24 下午6:57:30 
 *//*
public class ImgCompress {
	private static Image img;  
	private static int height;
	private static int width;

	public ImgCompress(MultipartFile pic) throws IOException{
		InputStream inputStream = pic.getInputStream();
		img = ImageIO.read(inputStream);
		width = img.getWidth(null);    // 得到源图宽  
		height = img.getHeight(null);
	}
	*//** 
	 * 按照宽度还是高度进行压缩 
	 * @param w int 最大宽度 
	 * @param h int 最大高度 
	 *//*  
	public JPEGImageEncoder resizeFix(int w, int h,boolean isAdd,String mark) throws IOException {  
		if (width / height > w / h) {  
			return  resizeByWidth(w,isAdd,mark);  
		} else {  
			return resizeByHeight(h,isAdd,mark);  
		}  
	}  
	*//** 
	 * 以宽度为基准，等比例放缩图片 
	 * @param w int 新宽度 
	 *//*  
	public JPEGImageEncoder resizeByWidth(int w,boolean isAdd,String mark) throws IOException {  
		int h = (int) (height * w / width);  
		return resize(w, h,isAdd,mark);  
	}  
	*//** 
	 * 以高度为基准，等比例缩放图片 
	 * @param h int 新高度 
	 *//*  
	public JPEGImageEncoder resizeByHeight(int h,boolean isAdd,String mark) throws IOException {  
		int w = (int) (width * h / height);  
		return resize(w, h,isAdd,mark);  
	}  
	public JPEGImageEncoder resize(int width,int height,boolean isAdd,String mark){
		return reduceImg(width, height,isAdd,mark);
	}
	public static JPEGImageEncoder reduceImg(int widthdist, int heightdist,boolean isAdd,String mark) {  
		@SuppressWarnings("restriction")
		JPEGImageEncoder encoder=null;
		try {  
			Image src = img;
			BufferedImage tag= new BufferedImage((int) widthdist, (int) heightdist,  
					BufferedImage.TYPE_INT_RGB);  
			tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_SMOOTH), 0, 0,  null);
			//图片添加水印
			if(isAdd){
				if(mark!=null&&!"".equals(mark)){
					AddImageMark(tag.getGraphics(),widthdist,heightdist,mark);
				}
			}
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			encoder = JPEGCodec.createJPEGEncoder(out);  
			encoder.encode(tag);
		} catch (IOException ex) {  
			ex.printStackTrace();  
		}  
		return encoder;
	}  
	*//**
	 * 实现图片水印的添加
	 * @param g
	 * @param x
	 * @param y
	 * @param mark
	 *//*
	public static void AddImageMark(Graphics g,int x,int y,String mark){
		int positionY_name=y-50;
		int positionX=x-160;
		int positionY=y-20;
		String[] marks = mark.split(",");
		//设置水印的颜色为白色
		g.setColor(Color.WHITE);
		//设置字体：
		Font f=new Font("宋体",Font.BOLD, 20);
		g.setFont(f);
		//设置水印的内容：
		g.drawString(marks[1],positionX,positionY);
		g.drawString(marks[0],positionX,positionY_name);
		//关闭画笔
		g.dispose();
	}

}
*/