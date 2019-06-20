package com.first.utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class Log {
	private final Class<?> clazz;//?:接收任一的类对象
	private Logger logger;
	public Log(Class<?> clazz){
		this.clazz = clazz;
		System.setProperty("org.uncommons.reportng.escape-output","false");//使报告文档有样式
		this.logger = LogManager.getLogger(this.clazz);
	}
	public void info(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#2A00FF\">【info】"+clazz.getCanonicalName()+"："+message + "</span><br />");
	}
	public void debug(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#2A00FF\">【debug】"+clazz.getCanonicalName()+"："+message + "</span><br />");
	}
	public void error(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#FF0000\">【error】"+clazz.getCanonicalName() + "：" + message + "</span><br />");
	}
	public void trace(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#2A00FF\">【trace】"+clazz.getCanonicalName()+"："+message + "</span><br />");
	}
	public void warn(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#2A00FF\">【warn】"+clazz.getCanonicalName()+"："+message + "</span><br />");
	}
	public void fatal(String message){
		logger.info(clazz.getCanonicalName()+"："+message);
		Reporter.log("<span style=\"color:#2A00FF\">【fatal】"+clazz.getCanonicalName()+"："+message + "</span><br />");
	}
	//在报告页面直接显示图片
	public void screenShotLog(String comm,File file){
		int width = 350;
		String absolute = "file:"+file.getAbsolutePath(); 
		Reporter.log("<a target='_blank' href=\"" +absolute + "\">" );
		Reporter.log("<img width=\"" + width + "\" src=\"" + absolute +"\" />	"+comm);
		Reporter.log("</a><br />");
	}

}
