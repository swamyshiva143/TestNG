package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.datadriven.util.Xls_Reader;

public class ParameterizeTest {
	
	public static void main(String[] args) {
		
		//webdriver code
		
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();	//launch browser
		
		driver.get("https://www.facebook.com/reg");
		
		
		//Data Driven Approach(Parameterization)---used to create data driven framework : driving the test data from excel files.
		//get test data from excel file
		Xls_Reader reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\TestNG\\TestNG\\src\\datadriven\\excel\\facebookDataDrivenTestData.xlsx");
		int rowCount =reader.getRowCount("RegTestData");
	
		// to add extra column in the excel sheet..
		reader.addColumn("RegTestData", "Status");
		
		//parameterization:
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			System.out.println("*****************");
			
			String firstName=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);
			
			String lastName= reader.getCellData("RegTestData", "lastname", rowNum );
			System.out.println(lastName);
			
			String mobileNo= reader.getCellData("RegTestData", "mobileno", rowNum );
			System.out.println(mobileNo);
			
			String password= reader.getCellData("RegTestData", "password", rowNum );
			System.out.println(password);
			
			String date= reader.getCellData("RegTestData", "date", rowNum );
			System.out.println(date);
			
			String month= reader.getCellData("RegTestData", "month", rowNum );
			System.out.println(month);
			
			String year= reader.getCellData("RegTestData", "year", rowNum );
			System.out.println(year);
			
			
			
			//enter data
			
			driver.findElement(By.xpath("//input[@name='firstname']")).clear();
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
			
			driver.findElement(By.xpath("//input[@name='lastname']")).clear();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobileNo);
			
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
			
			Select select= new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
			select.selectByVisibleText(date);
			
			Select select1= new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
			select1.selectByVisibleText(month);
			
			
			Select select2= new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
			select2.selectByVisibleText(year);
			
			
			reader.setCellData("RegTestData", "Status", rowNum, "pass");
			
		}
		
}
	
	

}
