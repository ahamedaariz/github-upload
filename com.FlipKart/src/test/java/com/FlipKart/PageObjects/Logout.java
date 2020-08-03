package com.FlipKart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlipKart.testCases.BaseClass;

public class Logout extends BaseClass {


	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div[1]/div")
	WebElement signinUser;
	
	@FindBy(xpath="//div[text()='Logout']")
	WebElement Logout;
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void logout() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(signinUser).build().perform();
		Thread.sleep(1000);
		Logout.click();	
	}
	
}