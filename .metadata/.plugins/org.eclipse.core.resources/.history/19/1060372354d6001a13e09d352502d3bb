package com.FlipKart.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public void readExcel() throws IOException
	{
		File srcfile =new File ("./ReadTestData//FlipKart_TestData.xlsx");
		// create a object of FileInputStream class to read the excel file
		FileInputStream fis=new FileInputStream(srcfile);

		XSSFWorkbook   wbook = new  XSSFWorkbook(fis);
		// read sheet inside the workbook
		XSSFSheet sheet =wbook.getSheetAt(0);

		HashMap<Integer, List<String>>   hmapObj = new HashMap<Integer, List<String>>();
		//Loop over all the rows of excel file to read it
		for (int i=1; i<sheet.getPhysicalNumberOfRows(); i++ )
		{
			XSSFRow  currentRow =sheet.getRow(i);

			List<String>mydata = new  ArrayList<String>();

		for (int j=0; j<currentRow.getLastCellNum(); j++ )
		{
			XSSFCell  currentCell =currentRow.getCell(j);

			mydata.add(currentCell.getStringCellValue());
		}

		hmapObj.put(i, mydata);

		}
		System.out.println(hmapObj);

	}
}
