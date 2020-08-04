package com.FlipKart.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FlipKart.testCases.BaseClass;

public class SearchPage extends BaseClass {

	@FindBy(name = "q")
	WebElement searchtext;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AddProduct searchItem(String searchitemtext) throws InterruptedException {
	Thread.sleep(1000);
		searchtext.sendKeys(searchitemtext + Keys.ENTER);
		return new AddProduct(driver);

	}

}
