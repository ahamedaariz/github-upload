package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtils.Utilities;

import base.BaseClass;


public class SearchPage extends BaseClass {

	@FindBy(name = "q")
	WebElement searchtext;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AddProduct searchItem(String searchitemtext) throws InterruptedException {
		
		Utilities.waits(searchtext);
		searchtext.sendKeys(searchitemtext + Keys.ENTER);
		return new AddProduct(driver);

	}

}
