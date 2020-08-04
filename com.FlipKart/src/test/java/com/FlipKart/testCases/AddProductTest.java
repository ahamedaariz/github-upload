package com.FlipKart.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FlipKart.PageObjects.AddProduct;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.FlipKart.ExtendReport.ListerenerTest.class)
public class AddProductTest extends BaseClass {

	AddProduct addproductdetails;

	@Test(description = "This method is used to validate the product add to card and validate the product's name")
	public void addProductValidation() throws InterruptedException {

		addproductdetails = new AddProduct(driver);
		try {
			addproductdetails.addProduct();
			test.log(LogStatus.INFO, "Selected Product is added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
