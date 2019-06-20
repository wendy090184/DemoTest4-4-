package com.first.actions;

import org.openqa.selenium.WebDriver;

import com.first.pages.LoginPage;
import com.first.pages.MainPage;


//import com.first.actions.LoginOperate;

public class LoginOperate {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		LoginOperate.driver = driver;
	}
	
	static LoginPage loginPage;
	static MainPage mainPage;
	//static PersonalInforma mainPage;
	public static  MainPage LoginSuess(String name,String password,String orgno){
		loginPage = new LoginPage(getDriver());
		loginPage.inputUserName(name);
		loginPage.inputPassword(password);
		loginPage.inputOrgno(orgno);
		loginPage.clickLoginButton();
		return new MainPage(getDriver());
	}
	public static String getLoginName(String name,String password,String orgno){
		mainPage = LoginSuess(name,password,orgno);
		return mainPage.getLoginUserName();
	}
}
