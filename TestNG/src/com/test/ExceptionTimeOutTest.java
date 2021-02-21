package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	// if the method running for infinite times, if u want to stop.... use..... invocationTimeOut....
	//expectedExceptions--- if u give.. then test case will be passed even if any exceptions occurs.....
	
	@Test(invocationTimeOut=200)
	public void infiniteLoopTest() {
		int i=1;
		while(i==1) {
			System.out.println(i);
		}
	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		
		String x= "100A";
		Integer.parseInt(x);
	}

}
