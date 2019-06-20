package com.first.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.first.actions.LoginOperate;
import com.first.pages.LoginPage;
import com.first.pages.MainPage;
import com.first.utils.AssertUtils;
import com.first.utils.ExeclUtils;
import com.first.utils.TestCase;
import junit.framework.Assert;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils;
	
  @BeforeTest
  
  public void setUp(){
	  try{
		  assertUtils= new AssertUtils();
		  driver = new ChromeDriver();//DriverFactory.getChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	  }catch(Exception e){
			e.printStackTrace();
			Assert.fail("测试初始化报错");
		}
  }
  //登录成功的测试用例
 @Test
  public void loginTest01() throws DocumentException {
	 List<TestCase> testcases=ExeclUtils.getUITestData("UITestData.xlsx");
	 HashMap<String,String> testdata=(HashMap<String, String>) testcases.get(0).getTestdata();
	 LoginOperate.setDriver(driver);
	 String value=LoginOperate.getLoginName(testdata.get("username"),testdata.get("password"),testdata.get("orgno"));
	 //String name=mp.getLoginName(); 
	 //assertUtils.checkContainsString(name,testcases.get(0).getExpectedResult());  
	 Assert.assertEquals("登录测试失败", true, value.contains("超级管理员"));
  }
   /* @Test
  public void loginTest02() throws DocumentException {
	  LoginPage lp = new LoginPage(driver);
	  String value = lp.loginFailOperate("sysadmin", "123456", "nx");
	  assertUtils.checkStringContains(value, "登录失败", "登录测试失败");
	  
  }  */
  @AfterTest
  public void tearDown() throws InterruptedException{
	  Thread.sleep(3000);
	  driver.quit();
  }
  
}
