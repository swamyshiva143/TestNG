package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	//1 //4 //7
	@BeforeMethod
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		driver =  new ChromeDriver();	//launch browser
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
	}
	
	//2
	@Test
	public void googleTitleTest() {
		String title= driver.getTitle();
		System.out.println(title);
				
	}
	
	//5
	@Test(priority=2, invocationCount=1)
	public void mailLinkTest() {
		boolean b= driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	
	//3  //6  //9
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
