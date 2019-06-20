package com.first.uiframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.first.uiframework.Locator.ByType;
import com.first.utils.Log;
import com.first.utils.xmlUtils;

public class WebElementUtils extends DriverUtils{
	private static Log log = new Log(WebElementUtils.class);
	
	protected HashMap<String,Locator> locatorMap;
	protected String path;
	public WebElementUtils(WebDriver dr){
		super(dr);
		path=System.getProperty("user.dir")+"/webelementdata/"+
				this.getClass().getSimpleName()+".xml";
		try {
			locatorMap = xmlUtils.readElementTnfo(path);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//点击，输入，提交，查找元素，获取元素属性，获取元素文本
	public WebElement getElement(Locator locator){
		WebElement el = null;
		ByType type = locator.getByType();
		try{
			switch(type){
			case id:
				el = driver.findElement(By.id(locator.getLocatorInfo()));
				break;
			case name:
				el = driver.findElement(By.name(locator.getLocatorInfo()));
				break;
			case xpath:
				el = driver.findElement(By.xpath(locator.getLocatorInfo()));
				break;
			case cssSelector:
				el = driver.findElement(By.cssSelector(locator.getLocatorInfo()));
				break;
		}}catch(Exception e){
			log.error("元素："+locator.getElementName()+"识别异常");
			takeScreenShot("findElementErrorImage");
			Assert.fail("查找元素异常，退出当前测试用例");
		}
		return el;
	}
	public WebElement findElement(Locator locator){
		WebDriverWait wait = new WebDriverWait(driver,locator.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {  
	           public WebElement apply(WebDriver d) {  
	                return getElement(locator);             
	            }  
	        });    
			return el;		
		
	}
	public void click(Locator locator){
		WebElement e = findElement (locator);
		e.click();	
		log.info("点击元素 ："+locator.getElementName());
	}
	public void input (Locator locator,String content){
		WebElement e = findElement (locator);
		e.sendKeys(content);	
		log.info("在元素 ："+locator.getElementName()+"输入："+content);
	}
	public void submit (Locator locator){
		WebElement e = findElement (locator);
		e.submit();	
	}
	public String getText (Locator locator){
		WebElement e = findElement (locator);
		log.info("获取元素："+locator.getElementName()+"文本值");
		return e.getText();	
	}
	
	public String getAttribute (Locator locator,String attribute){
		WebElement e = findElement (locator);
		return e.getAttribute(attribute);	
	}
	public Locator getLocator(String locatorName){
		Locator locator = locatorMap.get(locatorName);
		return locator;
	}
	
	
	
}
