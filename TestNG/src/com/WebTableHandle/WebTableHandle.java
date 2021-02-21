package com.WebTableHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.datadriven.util.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
		
		
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		//*[@id="customers"]/tbody/tr[4]/td[3]
		
		String beforeXpath_Company="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_Company="]/td[1]";
		
		String beforeXpath_Contact="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_Contact="]/td[2]";
		
		String beforeXpath_Country="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_Country="]/td[3]";
		
	List<WebElement> rows=	driver.findElements(By.xpath("//table[@id='customers']//tr"));
	System.out.println("Total no.of rows:--"+(rows.size()-1));
	int rowCount=rows.size();
	
	Xls_Reader reader=new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\TestNG\\TestNG\\src\\datadriven\\excel\\facebookDataDrivenTestData.xlsx");
	
	if(!reader.isSheetExist("TableData")) {
	reader.addSheet("TableData");
	reader.addColumn("TableData", "CompanyName");
	reader.addColumn("TableData", "ContactName");
	reader.addColumn("TableData", "CountryName");
	}
	
		for(int i=2; i<=rowCount; i++) {
			String actualXpath_Company=beforeXpath_Company+i+afterXpath_Company;
			String companyName=driver.findElement(By.xpath(actualXpath_Company)).getText();
			System.out.println(companyName);	
			reader.setCellData("TableData", "CompanyName", i, companyName);
			
			
			String actualXpath_Contact=beforeXpath_Contact+i+afterXpath_Contact;
			String contactName= driver.findElement(By.xpath(actualXpath_Contact)).getText();
			System.out.println(contactName);
			reader.setCellData("TableData", "ContactName", i, contactName);
			
			String actualXpath_Country=beforeXpath_Country+i+afterXpath_Country;
			String countryName=driver.findElement(By.xpath(actualXpath_Country)).getText();
			System.out.println(countryName);
			reader.setCellData("TableData", "CountryName", i, countryName);
			
			
			
		}
		
		
		
		
		
		

	}

}
