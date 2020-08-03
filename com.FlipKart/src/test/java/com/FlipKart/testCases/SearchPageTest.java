package com.FlipKart.testCases;

import org.testng.annotations.Test;
import com.FlipKart.PageObjects.AddProduct;
import com.FlipKart.PageObjects.SearchPage;

public class SearchPageTest extends BaseClass {

	SearchPage homePage;
	AddProduct addproduct;

	@Test(description = "This method is used to search the item")
	public void searchItemValidation() throws InterruptedException {
		homePage = new SearchPage(driver);
		addproduct = homePage.searchItem("Camera");

	}
}
