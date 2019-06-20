package com.first.uiframework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.first.config.LocalConfig;
import com.first.utils.Log;



public class DriverUtils {
	protected WebDriver driver;
	protected static MouseUtils mouse;
	protected static KeyBoardUtils keyboard;
	private static Log log = new Log(DriverUtils.class);
	
	public DriverUtils(WebDriver dr){
		driver = dr;
		mouse = new MouseUtils(dr);
		keyboard = new KeyBoardUtils(dr);
	}
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址"+url);
	}
	public void back(){
		driver.navigate().back();
		log.info("返回上一页");
	}
	public void forword(){
		driver.navigate().forward();
		log.info("向前进一页");
	}
	public void refresh(){
		driver.navigate().refresh();
	}
	public void wait(int seconds){
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//截图
    public void takeScreenShot(String... pngName) {
    	String fileName ;
    	String filePath = LocalConfig.SCREENSHOTPATH;
    	File file = new File(filePath);
    	if(!file.exists()) {
    	    file.mkdir();
    	}
        if (pngName.length == 0) {
        	fileName = "shotImage";
        } else {
        	fileName = pngName[0];
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path =  "\\"+ filePath +"\\" + fileName + "_" + dateStr + ".png";
        takeScreenShot(driver, path);    	
    }
    
    public void takeScreenShot(WebDriver drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
            log.error("失败截图保存的路径为:" + currentPath + path);
            FileUtils.copyFile(scrFile, picFile);
            log.info("截图成功！！！");
        } catch (Exception e) {
            log.error("截图失败！！！");
        } 
         //log.screenShotLog("截图：" + scrFile, picFile);
    }

	public WebDriver getDriver() {
		return driver;
	}


}
