package com.first.pages;

import org.openqa.selenium.WebDriver;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;

public class MainPage extends BasePage{
	
	public MainPage (WebDriver dr){
		super(dr);
	}
	Locator userMenu = getLocator("userMenu");
	public String getLoginUserName(){
		wait(2);
		return getText(userMenu);
	}

}
