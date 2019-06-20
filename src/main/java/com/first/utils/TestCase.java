package com.first.utils;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

	private String caseName=null;
	private String isCheck=null;  //是否启用检查点
	private String expectedResult=null;
	private Map<String,String> testdata=new HashMap<String,String>();
	
	public TestCase(String caseName,String isCheck,String expectedResult,Map<String,String> testdata){
		this.caseName=caseName;
		this.isCheck=isCheck;
		this.expectedResult=expectedResult;
		this.testdata=testdata;
	}
	
	public  String getCaseName(){
		return caseName;
	}
	
	public String getIsCheck(){
		return isCheck;
	}
	public String getExpectedResult() {
		return expectedResult;
	}

	public Map<String, String> getTestdata() {
		return testdata;
	}
	
}
