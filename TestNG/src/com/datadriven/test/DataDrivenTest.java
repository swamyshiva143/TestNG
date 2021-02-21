package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.datadriven.util.Xls_Reader;

public class DataDrivenTest {
	

	public static void main(String[] args) {
		

		//get test data from excel file
		Xls_Reader reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\TestNG\\TestNG\\src\\datadriven\\excel\\facebookDataDrivenTestData.xlsx");
		
		String firstName= reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName= reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);
		
		String mobileNo= reader.getCellData("RegTestData", "mobileno", 2);
		System.out.println(mobileNo);
		
		String password= reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		
		String date= reader.getCellData("RegTestData", "date", 2);
		System.out.println(date);
		
		String month= reader.getCellData("RegTestData", "month", 2);
		System.out.println(month);
		
		String year= reader.getCellData("RegTestData", "year", 2);
		System.out.println(year);
		
		String gender= reader.getCellData("RegTestData", "gender", 2);
		System.out.println(gender);
		
		

		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();	//launch browser
		
		
		driver.get("https://www.facebook.com/reg");		// enter url
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobileNo);
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
		
		Select select= new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		select.selectByVisibleText(date);
		
		Select select1= new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		select1.selectByVisibleText(month);
		
		
		Select select2= new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		select2.selectByVisibleText(year);
		
		
		
		
		
		
		

	}

}
