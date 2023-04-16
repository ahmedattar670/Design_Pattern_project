package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Product_details;
import pages.Search_page;

public class TestChangeCurrency extends TestBase{
	
	Search_page search_object;
	Product_details product;
	HomePage homeObject;
	
	@Test(priority = 1)
	public void ChangeTheCurrency() {
		
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();		
	}
	
	@Test(priority = 2)
	public void test_searching() {

		search_object = new Search_page(driver);
	
		product = new Product_details(driver);
		
		search_object.SearchByAutoSuggest("Mac");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		Assert.assertTrue(product.price.getText().contains("€"));
		System.out.println(product.price.getText());
		
	}

}
