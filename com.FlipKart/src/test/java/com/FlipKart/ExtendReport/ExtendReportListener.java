package com.FlipKart.ExtendReport;

import org.testng.annotations.BeforeTest;
import com.FlipKart.testCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportListener extends BaseClass {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest etest;

	@BeforeTest
	public ExtentReports setUp() {
		String reportLocation = System.getProperty("user.dir")
				+ "/test-output/extentReports.html";
		System.out.println(reportLocation);
		reporter = new ExtentHtmlReporter(reportLocation);
		reporter.config().setDocumentTitle("FlipKart Automation Test Report");
		reporter.config().setReportName("Automation Result Report");
		reporter.config().setTheme(Theme.DARK);
		System.out.println("Extent Report location initialized");
		reporter.start();

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Application", "FlipKart");
		extent.setSystemInfo("Operation System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		System.out.println("System Info. set in Extent Report");
		return extent;
	}

}
