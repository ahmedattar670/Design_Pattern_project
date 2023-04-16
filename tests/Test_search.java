package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Product_details;
import pages.Search_page;

public class Test_search extends TestBase {
	
	Search_page search_object;
	Product_details product;
	
	@Test
	public void test_searching() {

		search_object = new Search_page(driver);
	
		product = new Product_details(driver);
		
		search_object.search_for_item("mac");
		search_object.choose_the_product();
		
		Assert.assertTrue(product.actual_product.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		
	}
	

}
