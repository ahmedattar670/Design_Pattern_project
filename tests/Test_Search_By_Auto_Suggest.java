package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Product_details;
import pages.Search_page;

public class Test_Search_By_Auto_Suggest extends TestBase {
	
	Search_page search_object;
	Product_details product;
	
	@Test
	public void test_searching() {

		search_object = new Search_page(driver);
	
		product = new Product_details(driver);
		
		search_object.SearchByAutoSuggest("Mac");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(product.actual_product.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		
	}

	

}
