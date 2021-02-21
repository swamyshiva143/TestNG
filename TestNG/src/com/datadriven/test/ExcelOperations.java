package com.datadriven.test;

import com.datadriven.util.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
	
		//get test data from excel
		Xls_Reader reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\TestNG\\TestNG\\src\\datadriven\\excel\\facebookDataDrivenTestData.xlsx");
		
		
		if(!reader.isSheetExist("HomePage")) {
			reader.addSheet("HomePage");
		}
		
		
		int colCount=reader.getColumnCount("RegTestData");
		System.out.println("Total Columns present in RegTestData sheet:----"+colCount);
		
		int rowNum=reader.getCellRowNum("RegTestData", "firstname", "swamy");
		System.out.println("the Row number of given cell value:--"+rowNum);

	}

}
