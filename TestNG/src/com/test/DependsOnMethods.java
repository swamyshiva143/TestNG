package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependsOnMethods {
	
	//dependsOnMethods, used when we have some links to each other.. if logintest is not openends, otherw will be skippet.. so there is no time wasted.
	
		@BeforeMethod
		public void setUp() {
			System.out.println("@BeforeMethod.... setup props ");
		}
		
		@Test
		public void launchBrowser() {
			System.out.println("@BeforeTest.... launch browser ");
		}
		
		@Test
		public void login() {
			System.out.println("@BeforeClass..... log in to the page ");
		}
		
		@Test
		public void enterUrl() {
			System.out.println("@BeforeMethod..... enter url");
		}
		
		//Test case annotation--- starting with @Test
		@Test
		public void googleTitleTest() {
			System.out.println("@Test........ google title test ");
		}
		
		@Test(dependsOnMethods="googleTitleTest")
		public void searchTest() {
		System.out.println("@Test.... searchtest");	
		}
		
		@Test(dependsOnMethods="searchTest")
		public void googleLogoTest() {
			System.out.println("@Test......... googleLogo test");
		}
		
		
		@Test(dependsOnMethods="googleLogoTest")
		public void logout() {
			System.out.println("@AfteMethod...... logout ");
		}
		
		@Test
		public void closeBrowser() {
			System.out.println("@AfteClass... close browser ");
		}
		
		@AfterMethod
		public void deleteAllcookies() {
			System.out.println("@AfteTest....delete all cookines ");
		}
		

}
