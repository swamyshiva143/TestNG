package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterTest {
	WebDriver driver;
	
	
	@Test
	@Parameters({"browser", "url", "emailId"})
	public void yahoologinTest(String browser, String url, String emailId) {
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.get("url");
		
		driver.findElement(By.xpath("//input[@id='login-username']")).clear();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(emailId); //enter username
		
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		
	}

}
