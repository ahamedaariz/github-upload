package com.FlipKart.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.FlipKart.Utilities.Utilities;
import com.FlipKart.testCases.BaseClass;

public class AddProduct extends BaseClass {
	Utilities utilites;

	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/a/div[@class='_1-2Iqu row']/div[1]/div[1]")
	List<WebElement> clickProduct;

	@FindBy(xpath = "//input[@class='_3X4tVa' and @type='text']")
	WebElement pincodetxt;

	@FindBy(xpath = "//span[text()='Check']")
	WebElement checklink;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addtocart;

	@FindBy(xpath = "//div[text()='Remove']")
	WebElement removebtn;
	@FindBy(xpath = "(//div[text()='Remove'])[1]")
	WebElement removeitem;

	public AddProduct(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Get the random product
	public void addProduct() throws InterruptedException {
		int rand = 0;
		Random random = new Random();
		while (true) {
			rand = random.nextInt(23);
			break;
		}
		System.out.println(rand);
		
		// Scrolling the webpage by using JavascriptExecutor interface
		Utilities.scrollWebPage();
		
		clickProduct.get(rand).click();
		String getProductName = clickProduct.get(rand).getText();
		System.out.println("The clickable item is:" + getProductName);
		String parentWindow = driver.getWindowHandle();

		// This static method call is used to handle windows
		Utilities.windowHandles(parentWindow);
		checkPincode("700001");
		Thread.sleep(2000);
		addtocart.click();
		
		
		String GetAddedProdectName = driver.getPageSource();
		if (GetAddedProdectName.contains(getProductName)) {
			Assert.assertTrue(true, getProductName
					+ " --> Product name is displayed ");
		}

		else {
			Assert.assertFalse(false, getProductName
					+ " --> Product name is not displayed ");
		}

		Thread.sleep(2000);
		removebtn.click();
		Thread.sleep(1000);
		removeitem.click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void checkPincode(String setpincode) {
		pincodetxt.sendKeys(setpincode);
		checklink.click();
	}

}
