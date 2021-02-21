package com.datadriven.util;

import java.util.ArrayList;

public class facebookUtil {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\TestNG\\TestNG\\src\\datadriven\\excel\\facebookDataDrivenTestData.xlsx");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		for(int rowNum=2; rowNum<=reader.getRowCount("RegTestData");rowNum++) {
			String firstName=reader.getCellData("RegTestData", "firstname", rowNum);
			
			String lastName=reader.getCellData("RegTestData", "lastname", rowNum);
			
			String mobileNo=reader.getCellData("RegTestData", "mobileno", rowNum);
			
			String password=reader.getCellData("RegTestData", "password", rowNum);
			
			Object ob[] = {firstName, lastName, mobileNo, password};
			
			myData.add(ob);
			
		}

		return myData;
	}
	
	

}
