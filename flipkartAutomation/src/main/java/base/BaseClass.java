package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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

	@BeforeTest(description = "It is used for supporting different browsers")
	@Parameters({ "TestCaseId", "browsers" })
	public static void initialization(String TestcaseId, String browsername)
			throws MalformedURLException {

		testCaseId = TestcaseId;

		String baseURL = ReadExcelData.getcellData_Test("Config", TestcaseId,
				"URL");

		if (browsername.equalsIgnoreCase("chrome")) {
			try {
				String hubUrl = "http://192.168.1.3:4444/wd/hub";
				DesiredCapabilities chromeCapabilities = new DesiredCapabilities();
				chromeCapabilities.setBrowserName(browsername);
				chromeCapabilities.setPlatform(Platform.WINDOWS);
				ChromeOptions options = new ChromeOptions();
				options.merge(chromeCapabilities);
				driver = new RemoteWebDriver(new URL(hubUrl), options);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (browsername.equalsIgnoreCase("Firefox")) {
			String hubUrl = "http://192.168.1.3:4444/wd/hub";

			DesiredCapabilities ffCapabilities = new DesiredCapabilities();
			ffCapabilities.setPlatform(Platform.WINDOWS);
			ffCapabilities.setBrowserName(browsername);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.merge(ffCapabilities);
			driver = new RemoteWebDriver(new URL(hubUrl), firefoxOptions);
		}

		else if (browsername.equalsIgnoreCase("ie")) {
			String hubUrl = "http://192.168.1.3:4444/wd/hub";
			DesiredCapabilities ieCapabilities = new DesiredCapabilities();
			ieCapabilities.setBrowserName(browsername);
			ieCapabilities.setPlatform(Platform.WINDOWS);
			InternetExplorerOptions ieoptions = new InternetExplorerOptions();
			ieoptions.setCapability("ie.usePerProcessProxy", "true");
			ieoptions.setCapability("requireWindowFocus", "false");
			ieoptions
					.setCapability("ie.browserCommandLineSwitches", "-private");
			ieoptions.setCapability("ie.ensureCleanSession", "true");
			ieoptions.merge(ieCapabilities);
			driver = new RemoteWebDriver(new URL(hubUrl), ieoptions);

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterTest(description = "used for closing all browser after executing application")
	public void tearDown() {
		driver.quit();
	}

}
