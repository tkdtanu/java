package com.tavant.unittest;

import java.util.List;

public class MyDemoClass {
	
	MyDemoDataClass data = new MyDemoDataClass();
	
	public String concatinateString(String firstString, String secondString) {
		return firstString.concat(secondString);
	}
	
	public List<String> getStudents(){
		return data.getAllStudentsName();
	}

}
