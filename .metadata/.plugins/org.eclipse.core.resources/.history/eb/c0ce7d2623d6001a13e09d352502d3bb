package com.FlipKart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.FlipKart.PageObjects.AddProduct;
import com.FlipKart.testCases.BaseClass;

public class Utilities extends BaseClass {
	AddProduct addproduct;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static void scrollWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}

	public static void windowHandles(String superWindow) {
		String parentWindow = superWindow;
		Set<String> windows = driver.getWindowHandles();
		while (windows.size() != 0) {
			if (windows.size() > 1) {
				break;
			}

			windows = driver.getWindowHandles();
		}

		for (String childWindow : windows) {
			if (childWindow != parentWindow) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	// This method helps to take screenshot
	public static String takeScreenshot(WebDriver driver, String screenShotName) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh:mm:ss");
			Date date = new Date();
			time = dateFormat.format(date);
			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);

			path = System.getProperty("user.dir") + "/Screenshots/"
					+ screenShotName + time + ".png";

			File destination = new File(path);
			FileUtils.copyFile(src, destination);
			System.out.println("Screen shot taken");
		} catch (Exception ex) {
			System.out.println("Screenshot error is" + ex.getMessage());
		}
		return path;
	}

	// Get Cell data
	public static String getcellData_Test(String path, String sheet, String key) {
		String CellData = "";
		int RowNum = 1;

		try {
			FileInputStream fis = new FileInputStream(new File(path));
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet1 = wb.getSheet(sheet);

			int columnCount = sheet1.getRow(0).getLastCellNum();
			for (int cell = 0; cell <= columnCount; cell++) {
				String RowData = sheet1.getRow(0).getCell(cell).toString();
				if (RowData.trim().equalsIgnoreCase(key)) {
					CellData = sheet1.getRow(RowNum).getCell(cell).toString();
					break;
				}
			}

		} catch (Exception e) {
			// reporter.log(LogStatus.ERROR,"Data Failed to fetch, Please check the Excel Sheet Method Parameters");
			// Assert.fail();
		}
		return CellData;
	}

	// *************************---***************************//////

	public static String getcellData_OBR_PC(String path, String sheet,
			String key, String columnName) {
		String CellData = "";
		int ColumnNum = 1;
		if (columnName.equalsIgnoreCase("LocatorType"))
			ColumnNum = 1;
		else if (columnName.equalsIgnoreCase("LocatorValue"))
			ColumnNum = 2;
		else if (columnName.equalsIgnoreCase("Value"))
			ColumnNum = 1;

		try {
			FileInputStream fis = new FileInputStream(new File(path));
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet1 = wb.getSheet(sheet);

			int rowCount = sheet1.getLastRowNum();
			for (int row = 1; row <= rowCount + 1; row++) {
				String RowData = sheet1.getRow(row).getCell(0).toString();
				if (RowData.trim().equalsIgnoreCase(key)) {
					CellData = sheet1.getRow(row).getCell(ColumnNum).toString();
					break;
				}
			}

		} catch (Exception e) {
		}
		return CellData;
	}

}
