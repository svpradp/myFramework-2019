package com.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	//Constructor
	public ExcelDataProvider()
	{
		File src = new File("./myResources/TestData/myTestData.xlsx");
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			
			wb= new XSSFWorkbook(fis);
		} 
		
		catch (Exception e) {
			
			System.out.println("Unable to read excel file"+e.getMessage());;
		}	

	}
	
	public String getStringData(String SheetName, int row, int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	//method overloading
	public String getStringData(int SheetIndex, int row, int column)
	{
		//XSSFWorkbook, XSSFSheet, XSSFRow,XSSFCell are the classes which can be consolidated to below
		
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	
	public double getNumericData(String SheetName, int row, int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	

}
