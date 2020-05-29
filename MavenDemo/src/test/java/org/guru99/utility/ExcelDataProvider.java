package org.guru99.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File file = new File("./ExcelData/Data.xlsx");
	
		try
		{
		FileInputStream fis = new FileInputStream(file);
		
		wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("Excel Data file is not found: " + e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int rownum, int cellnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

	public double getIntData(String sheetName, int rownum, int cellnum)
	{
		return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}
}
