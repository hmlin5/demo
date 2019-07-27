package com.hmlin5.demo;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @Title: PropertiesUtil.java
 * @Package cn.com.bluemoon.utils
 * @Description: 配置文件操作类
 * @author 姚宇延
 * @date 2015年12月19日 上午11:17:42
 * @version V1.0
 */
public class PropertiesUtil {

	/**
	 * 获取属性值
	 * 
	 * @param filePath
	 *            文件路径
	 * @param name
	 *            属性名
	 * @return 属性值
	 */
	public static String getProperty(String filePath, String name) {
		String value = "";
		String realPath = filePath;
		String classPath = "";
		try {
			classPath = PropertiesUtil.class.getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		try {
			FileInputStream is = new FileInputStream(new File(classPath + realPath));
			Properties pro = new Properties();
			pro.load(is);
			value = pro.getProperty(name);
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法解析文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("无法解析文件");
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 设置配置文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @param params
	 *            参数列表
	 */
	public static void setProperty(String filePath, Map<String, String> params) {
		try {
			Properties prop = new Properties();
			/** 赋值 **/
			for (String propertyName : params.keySet()) {
				prop.setProperty(propertyName, params.get(propertyName));
			}

			/** 写入 **/
			OutputStream fos = new FileOutputStream(filePath);
			prop.store(fos, "The New properties file");
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("----设置文件路径失败----");
			e.printStackTrace();
		}
	}
}
