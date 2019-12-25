package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider { 
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/Data.xlsx");
		 try {
			FileInputStream Fin= new FileInputStream(src);
			
			wb=new XSSFWorkbook(Fin);
		} catch (Exception e) {
				System.out.println("Unable to read the Excel file"+ e.getMessage());
		    }
	}
		public String getStringData(int SheetIndex,int row,int column)
		{
		 return	wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		}
		public String getStringData(String SheetName,int row,int column)
		{
			 return	wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		 }
		public double getNumericData(String SheetNum,int row,int column)
		{
			 return	wb.getSheet(SheetNum).getRow(row).getCell(column).getNumericCellValue();

		}
	
}
