package com.FlipKart.testCases;

import org.testng.annotations.BeforeSuite;

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

import com.FlipKart.Utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static String time;
	public static String path;
	public static ExtentReports reports;
	public static ExtentTest test;

	public BaseClass() {
		try {
			prop = new Properties();
			String configpath = System.getProperty("user.dir");
			File srcfile = new File(configpath
					+ "//Configuration/config.properties");
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
	public static void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverpath
					+ "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("Firefox")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverpath
					+ "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("ie")) {
			String driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", driverpath
					+ "//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseURL"));
	}

	@AfterSuite(description = "used for closing all browser after executing application")
	public void tearDown() {
		driver.quit();
	}

}
