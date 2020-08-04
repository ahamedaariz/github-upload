package com.FlipKart.testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.FlipKart.PageObjects.LoginPage;
import com.FlipKart.PageObjects.SearchPage;
import com.FlipKart.ExtendReport.*;


public class LoginPageTest extends BaseClass{
	
	LoginPage loginFlip;
	SearchPage homePage;
	public LoginPageTest()
	{
		super();
		
	}
	
	@Test(description="validate the login of the application's mobile number and password")
	public void loginTest() throws InterruptedException
	{
		loginFlip = new LoginPage(driver);
		homePage=loginFlip.validateLogin(prop.getProperty("loginMobileNumber"), prop.getProperty("loginPassword"));
		System.out.println("Login in Successfully");
		String actual =driver.getTitle();
		System.out.println(actual);
		String expected ="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);
		
	}
	

}