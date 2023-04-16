package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Add_To_Cart_page;
import pages.Product_details;
import pages.Search_page;

public class TestAddToCart extends TestBase{

	Search_page search_object;
	Product_details product;
	Add_To_Cart_page cart;

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
	public void userCanAddToCart() {

		cart = new Add_To_Cart_page(driver);
		product.add_to_cart();
		product.OpenCartPage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(cart.productName.getText().contains("Apple MacBook Pro 13-inch"));

	}

	@Test(priority = 3)
	public void userCanAddQuantity() throws InterruptedException {

	     Thread.sleep(1000);
	//	cart.updateQuantityInCart("3");
		//Thread.sleep(2000);
		Assert.assertTrue(cart.total_price.getText().contains("3,600.00"));
	}

	@Test(priority = 4)
	public void userCanRemoveFromCart() {
		cart.RemoveProduct();
		Assert.assertTrue(cart.NoDateMessage.getText().contains("Your Shopping Cart is empty!"));
	}


}
