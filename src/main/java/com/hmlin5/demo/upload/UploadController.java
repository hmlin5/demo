/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.hmlin5.demo.upload;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/file")
public class UploadController  {

	
	//@Value("${web.upload-path}")
    public  String MULTIMEDIA_PATH; 
	
	//@Value("${web.resource-url}")
	public  String RESOURECE_URL;
	
	
	
	
	@RequestMapping(value = {"/upload"})
	@ResponseBody
	public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile  uploadFile, HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> map = new HashMap<>();
		try {


			String uploadParam = request.getParameter("uploadParam");
			System.out.println(uploadParam);

			String year = Calendar.getInstance().get(Calendar.YEAR)+"";
			String month = Calendar.getInstance().get(Calendar.MONTH)+1+"";
			String day = Calendar.getInstance().get(Calendar.DATE)+"";
				// 设定上传文件保存的目录 
				//String savePath = req.getSession().getServletContext().getRealPath("/userfiles/bid");  
			String savePath = MULTIMEDIA_PATH+year+"/"+month+"/"+day ; 
			String urlPath = RESOURECE_URL+year+"/"+month+"/"+day ; 
				//如果保存路径不存在则创建
				File f = new File(savePath);  
				if (!f.exists()) {
					f.mkdirs();  
				}
			
//				MultipartHttpServletRequest request = (MultipartHttpServletRequest)req;
//				MultipartFile uploadFile = request.getFile("upload");
				if(!uploadFile.isEmpty()){//如果上传文件不为空
				
					String fileName = uploadFile.getOriginalFilename();//上传文件的名称
					String suffix = fileName.substring(fileName.lastIndexOf(".") );
					int size = (int) uploadFile.getSize();//上传文件的大小
					
					String saveName = UUID.randomUUID().toString().replace("-", "")+suffix;//保存到服务器端的文件名称
					String realPath = savePath+"/"+saveName;//上传文件在服务器端的真实路径
					File saveFile = new File(realPath);
					
					uploadFile.transferTo(saveFile);//保存上传文件

					map.put("data", urlPath+"/"+saveName);
					map.put("path", savePath+"/"+saveName);
					map.put("code",1);
				}
			
		} catch (Exception e) {
			map.put("code", -1);
			map.put("msg", "服务器忙，请稍后再试！");
			map.put("data", null);
			e.printStackTrace();
		} 
		
		return map;
	}

	

}