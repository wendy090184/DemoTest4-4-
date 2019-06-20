package com.first.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.first.config.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;


public class LoginPage extends BasePage {
	
	private Alert alert;
	
	//封装
	/*public WebDriver getDriver() {
		return driver;
	}*/
	
	//构造函数
	public LoginPage(WebDriver dr){
		super(dr);
		openWeb(LocalConfig.URL);
	}
	Locator usernameInputbox = getLocator("usernameInputbox");
	Locator passwordInputbox = getLocator("passwordInputbox");
	Locator orgnoInputbox = getLocator("orgnoInputbox");
	Locator loginButton = getLocator("loginButton");
	
	public void inputUserName(String name){
		input(usernameInputbox,name);
	}
	public void inputPassword(String password){
		input(passwordInputbox,password);
	}
	public void inputOrgno(String orgno){
		input(orgnoInputbox,orgno);
	}
	public void clickLoginButton(){
		click(loginButton);
	}
	
	/*public MainPage loginOperate (String name , String password , String orgno) {
		input(usernameInputbox,name);
		input(passwordInputbox,password);
		input(orgnoInputbox,orgno);
		click(loginButton);
		return new MainPage(driver);	//返回到首页(把这个driver送给MainPage类的driver)
		}
	public String loginFailOperate(String name,String password, String orgno){
		input(usernameInputbox,name);
		input(passwordInputbox,password);
		input(orgnoInputbox,orgno);
		click(loginButton);
		wait(2);
		String value = getalertText();
		alertAccept();
		return value;
	}
	public void aaa(){
		//MouseUtils mouse = new MouseUtils(driver);
		mouse.doubleClick(findElement(loginButton));
	}
	public void bbb(){
		mouse.doubleClick(findElement(loginButton));
	}
*/
}
