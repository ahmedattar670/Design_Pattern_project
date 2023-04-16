package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.Product_details;
import pages.Search_page;

public class TestCompareProducts extends TestBase {
	
	Search_page search_object;
	Product_details product;
	ComparePage compareObject;
	
	@Test(priority = 1)
	public void test_searching() {

		search_object = new Search_page(driver);
		product = new Product_details(driver);
		compareObject = new ComparePage(driver);
		
		search_object.SearchByAutoSuggest("Mac");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		product.Add_to_compare_list();
		
		search_object.SearchByAutoSuggest("asus");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		product.Add_to_compare_list();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		product.Open_Comparison_Page();
		
		Assert.assertTrue(compareObject.firstProduct.isDisplayed());
		Assert.assertTrue(compareObject.SecondProduct.isDisplayed());
		
		compareObject.CompareTheProducts();
	
	}
	
	@Test(priority = 2)
	public void clearComparisonList() {
		compareObject.ClearAllProducts();
		Assert.assertTrue(compareObject.NoDataMessage.getText().contains("You have no items to compare."));
	}

}
