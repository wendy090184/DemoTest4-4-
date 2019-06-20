package com.first.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static Properties properties = null;
	private static String propertiesFileName;
	public PropertiesUtils(String path){
		this.propertiesFileName = path;
	}
	public static String getPropertieValue(String keyName){
		properties = new Properties();
		InputStream in=PropertiesUtils.class.getClassLoader()
				.getResourceAsStream("com/first/config/" + propertiesFileName);
		String value = null;
		try {
			properties.load(in);
			value = properties.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	

}
