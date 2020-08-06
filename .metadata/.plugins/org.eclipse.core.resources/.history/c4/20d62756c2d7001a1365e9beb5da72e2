package base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import commonUtils.ReadExcelData;
import commonUtils.Utilities;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static String time;
	public static String path;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String testCaseId;

	public BaseClass() {
		try {
			prop = new Properties();
			String configpath = System.getProperty("user.dir");
			File srcfile = new File(configpath
					+ "/src/test/resources/testData/config.properties");
			FileInputStream fis = new FileInputStream(srcfile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Exception is:" + e.getMessage());
		}
	}

	@BeforeSuite(description = "It is used for supporting different browsers")
	@Parameters(value = { "TestCaseId" })
	public static void initialization(String TestcaseId) {

		testCaseId = TestcaseId;

		String baseURL = ReadExcelData.getcellData_Test("Config", TestcaseId,
				"URL");
		String browsername = ReadExcelData.getcellData_Test("Config",
				TestcaseId, "Browser");

		if (browsername.equals("chrome")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverpath
					+ "/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("Firefox")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverpath
					+ "/src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("ie")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", driverpath
					+ "/src/main/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterSuite(description = "used for closing all browser after executing application")
	public void tearDown() {
		driver.quit();
	}

}
