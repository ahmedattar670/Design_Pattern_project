package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Product_details;
import pages.Search_page;
import pages.Whishlist_page;

public class TestAddToWishlist extends TestBase{
	
	Search_page search_object;
	Product_details product;
	Whishlist_page whishObject;
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void Whishlist() {
		
		whishObject = new Whishlist_page(driver);
		product.addToWhishList();
		product.OpenWhishListPage();
		Assert.assertTrue(whishObject.header.isDisplayed());
		Assert.assertTrue(whishObject.ProductCell.getText().contains("Apple MacBook Pro 13-inch"));
		whishObject.Remove_Product_from_cart();
		Assert.assertTrue(whishObject.successMsg.getText().contains("The wishlist is empty!"));
		

	}
	
	

}
