package pageObjects;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.Utilities;

import base.BaseClass;

public class SearchPage extends BaseClass {

	@FindBy(name = "q")
	WebElement searchtext;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchItem(String searchitemtext) throws InterruptedException {

		Utilities.waits(searchtext);
		searchtext.sendKeys(searchitemtext + Keys.ENTER);

	}

}
