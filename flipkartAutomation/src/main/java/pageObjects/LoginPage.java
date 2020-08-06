package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement loginmblNo;

	@FindBy(xpath = "//input[@type='password' and @class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement loginpassword;

	@FindBy(xpath = "//button[@type='submit' and @class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginbtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateLogin(String mblno, String passwrd) {
		loginmblNo.sendKeys(mblno);
		loginpassword.sendKeys(passwrd);
		loginbtn.click();
	}

}
