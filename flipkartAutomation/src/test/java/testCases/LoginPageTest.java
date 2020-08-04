package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SearchPage;
import base.BaseClass;

import com.relevantcodes.extentreports.LogStatus;
import commonUtils.ReadExcelData;

@Listeners(commonUtils.ListerenerTest.class)
public class LoginPageTest extends BaseClass {

	LoginPage loginFlip;
	SearchPage homePage;

	public LoginPageTest() {
		super();

	}

	@Test(description = "validate the login of the application's mobile number and password")
	public void loginTest() throws InterruptedException {
		loginFlip = new LoginPage(driver);
		String UserName = ReadExcelData.getcellData_Test( "Login",
				testCaseId, "Username");
		String Password = ReadExcelData.getcellData_Test( "Login",
				testCaseId, "Password");

		homePage = loginFlip.validateLogin(UserName, Password);

		test.log(LogStatus.INFO, "User is Login Successfully");
		String actual = driver.getTitle();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "Home page Title is verified successfully");

	}

}