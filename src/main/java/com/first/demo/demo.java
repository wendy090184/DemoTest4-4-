package com.first.demo;

import org.openqa.selenium.WebDriver;

import com.first.uiframework.DriverFactory;
import com.first.utils.PropertiesUtils;

public class demo {

	public static void main(String[] args) {
		PropertiesUtils propertiesUtils = new PropertiesUtils("local.properties");
		String url = propertiesUtils.getPropertieValue("url");
		System.out.println(url);
		/*WebDriver driver = DriverFactory.getChromeDriver();
		driver.get("https://service.czworks.cn");*/
		/*String path = System.getProperty("user.dir");
		System.out.println(path + "\\Driver");*/
		
	}

}
