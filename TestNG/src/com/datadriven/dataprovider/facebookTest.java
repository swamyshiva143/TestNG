package com.datadriven.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.datadriven.util.facebookUtil;

public class facebookTest {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/reg");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData= facebookUtil.getDataFromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void facebookRegPageTest(String firstName, String lastName, String mobileNo, String password) {
		
		//enter data
		
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobileNo);
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
