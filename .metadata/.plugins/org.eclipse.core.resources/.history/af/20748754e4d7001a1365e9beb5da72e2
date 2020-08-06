package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Logout;
import base.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

@Listeners(commonUtils.ListerenerTest.class)
public class LogoutTest extends BaseClass {
	Logout signout;

	@Test(description = "This method used to logout the application")
	public void userLogout() throws InterruptedException {
		signout = new Logout(driver);
		signout.logout();
		test.log(LogStatus.INFO, "User is logout successfully");
	}

}
