package commonUtils;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import pageObjects.AddProduct;
import base.BaseClass;

public class Utilities extends BaseClass {
	AddProduct addproduct;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static void scrollWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}

	public static void waits(WebElement web)
	{
	WebDriverWait wait = new WebDriverWait(driver, 45);
	wait.until(ExpectedConditions.visibilityOf(web));
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

		public static String getScreenshotName(ITestResult result) {
		return System.getProperty("user.dir") + "/Screenshots/"
				+ result.getMethod().getMethodName() + '_'
				+ new SimpleDateFormat("yyyy-MM-dd hh-mm").format(new Date())
				+ ".png";
	}

	public static String getReportName() {
		return System.getProperty("user.dir")
				+ "/Reports/"
				+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss")
						.format(new Date()) + '_' + "reports.html";
	}

}
