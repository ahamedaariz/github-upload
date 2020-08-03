package com.FlipKart.testCases;

import org.testng.annotations.Test;
import com.FlipKart.PageObjects.AddProduct;

public class AddProductTest extends BaseClass {

	AddProduct addproductdetails;

	@Test(description = "This method is used to validate the product add to card and validate the product's name")
	public void addProductValidation() throws InterruptedException {

		addproductdetails = new AddProduct(driver);
		addproductdetails.addProduct();
	}

}
