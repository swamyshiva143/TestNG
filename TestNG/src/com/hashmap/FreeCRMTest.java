package com.hashmap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest {

	WebDriver driver;
	public String credentials;
	public String credentialsInfo[];
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://ui.cogmento.com/");
		
	}
	
	/*
	 * @Test
	 * url
	 * login with customer user
	 * place the order
	 * logout
	 * login with admin user
	 * check the order
	 * check all the orders for the day
	 * logout
	 * 
	 */
	
	@Test(priority=1)
	
	public void loginWithCustomerUserTest() throws InterruptedException {
		credentials=FreeCrmData.getUserLoginInfo().get("customer");
		credentialsInfo= credentials.split("_");
		
		driver.findElement(By.name("email")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);
		
		WebElement loginBtn= driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
		//	Thread.sleep(2000);
		
		//driver.switchTo().frame("mainframe");
		//Select select = new Select(driver.findElement(By.name("slctMonth")));
		//select.selectByVisibleText(FreeCrmData.monthMap().get(10));	
		
	}
	
@Test(priority=2)
	
	public void loginWithAdminUserTest() throws InterruptedException {
		credentials=FreeCrmData.getUserLoginInfo().get("admin");
		credentialsInfo= credentials.split("_");
		
		driver.findElement(By.name("email")).sendKeys(credentialsInfo[0]);
		driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);
		
		WebElement loginBtn= driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
}
	
	
	
	
}
