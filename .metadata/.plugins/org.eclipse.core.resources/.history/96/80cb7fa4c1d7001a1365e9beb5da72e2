package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.BaseClassFinder;

import base.BaseClass;

import com.relevantcodes.extentreports.LogStatus;
import commonUtils.Utilities;

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

		// Scrolling the webpage by using JavascriptExecutor interface
		Utilities.scrollWebPage();

		clickProduct.get(rand).click();
		test.log(LogStatus.INFO,
				"Select the Random product from the list of camera");

		String getProductName = clickProduct.get(rand).getText();
		String parentWindow = driver.getWindowHandle();

		// This static method call is used to handle windows
		Utilities.windowHandles(parentWindow);
		test.log(LogStatus.INFO,
				"Window handling action is performed Successfully");
		checkPincode("700001");
	
		Utilities.waits(addtocart);
		addtocart.click();
		test.log(LogStatus.INFO,
				"The selected Product is added to the cart Successfully");

		String GetAddedProdectName = driver.getPageSource();
		if (GetAddedProdectName.contains(getProductName)) {
			Assert.assertTrue(true, getProductName);
			test.log(LogStatus.INFO,
					"The Added Product name is equal to the checked out product name");
		}

		else {
			Assert.assertFalse(false, getProductName);
		}

		driver.close();
		driver.switchTo().window(parentWindow);

	}

	// this method is used to set the pincode
	public void checkPincode(String setpincode) {
		
		pincodetxt.sendKeys(setpincode);
		Utilities.waits(pincodetxt);
		checklink.click();
	}

}
