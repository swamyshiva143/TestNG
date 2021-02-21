package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	//Pre conditional annotations start with @Before
	
	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite.... setup props ");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest.... launch browser ");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass..... log in to the page ");
	}
	
	@BeforeMethod
	public void enterUrl() {
		System.out.println("@BeforeMethod..... enter url");
	}
	
	//Test case annotation--- starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("@Test........ google title test ");
	}
	
	@Test
	public void searchTest() {
	System.out.println("@Test.... searchtest");	
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("@Test......... googleLogo test");
	}
	
	//Post-conditional annotations... starting with @After
	@AfterMethod
	public void logout() {
		System.out.println("@AfteMethod...... logout ");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfteClass... close browser ");
	}
	
	@AfterTest
	public void deleteAllcookies() {
		System.out.println("@AfteTest....delete all cookines ");
	}
	
}
