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

import com.datadriven.util.DataDrivenTestUtil;

public class HalfEbayTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.half.ebay.com");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData= DataDrivenTestUtil.getDataFromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider= "getTestData")
	public void HalfEbayRegPageTest(String firstName, String lastName, String address1,
			String address2, String city, String state, String zipCode, String emailAddress) {
		
		//enter data
		
		driver.findElement(By.xpath("//@[id='firstname']")).clear();
		driver.findElement(By.xpath("//#[id='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//@[id='lastname']")).clear();
		driver.findElement(By.xpath("//#[id='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//@[id='address1']")).clear();
		driver.findElement(By.xpath("//#[id='address1']")).sendKeys(address1);
		
		driver.findElement(By.xpath("//@[id='address2']")).clear();
		driver.findElement(By.xpath("//#[id='address2']")).sendKeys(address2);
		
		driver.findElement(By.xpath("//@[id='city']")).clear();
		driver.findElement(By.xpath("//#[id='city']")).sendKeys(city);
		
		driver.findElement(By.xpath("//@[id='state']")).clear();
		driver.findElement(By.xpath("//#[id='state']")).sendKeys(state);
		
		driver.findElement(By.xpath("//@[id='zipCode']")).clear();
		driver.findElement(By.xpath("//#[id='zipCode']")).sendKeys(zipCode);
		
		driver.findElement(By.xpath("//@[id='emailaddress']")).clear();
		driver.findElement(By.xpath("//#[id='emailaddress']")).sendKeys(emailAddress);
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
