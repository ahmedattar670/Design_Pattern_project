package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Add_To_Cart_page;
import pages.Checkout_page;
import pages.HomePage;
import pages.Order_details_page;
import pages.Product_details;
import pages.RegistrationPage;
import pages.Search_page;
import pages.UserLogin;

public class test_Registered_checkout extends TestBase{
	
	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;
	Search_page search_object;
	Product_details product1;
	Add_To_Cart_page cart;
	Checkout_page checkout1;
	Order_details_page order1;
	String FirstName = "ahmedd";
	String LastName = "attar";
	String myMail = "r80i@gmail.com";
	String Password = "1234567";
	String MyCity = "giza";
	String MyAddress = "street123";
	String PostalCode = "23765"; 
	String PhoneNumber = "01928378553";
			
			
	@Test(priority = 1)
	public void UserCanRegister() {
		
		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration(FirstName,LastName,myMail,Password);
		Assert.assertTrue(RegisterObject.successtxt.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void UserCanLogout() {
		
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@Test(priority = 3)
	public void UserCanLogin() {
		
		homeObject.clickLoginbtn();
		loginObject = new UserLogin(driver);
		
		loginObject.userLoginUser(myMail,Password);
		Assert.assertTrue(loginObject.logOutbtn.isDisplayed());
	}
	
	@Test(priority = 4)
	public void test_searching() {

		search_object = new Search_page(driver);
	
		product1 = new Product_details(driver);
		
		search_object.SearchByAutoSuggest("Mac");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(product1.actual_product.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		
	}
	
	@Test(priority = 5)
	public void userCanAddToCart() {

		cart = new Add_To_Cart_page(driver);
		product1.add_to_cart();
		product1.OpenCartPage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(cart.productName.getText().contains("Apple MacBook Pro 13-inch"));
		cart.chcekout();

	}
	
	@Test(priority = 6)
	public void userCanCheckout() throws InterruptedException {
		
		checkout1 = new Checkout_page(driver);
		Thread.sleep(2000);
		checkout1.userFillCheckoutDetails(FirstName,LastName,myMail,MyCity,MyAddress,PostalCode, PhoneNumber);
		Assert.assertTrue(checkout1.Thankyoulbl.isDisplayed());		
		checkout1.OpenOrderDetailsPage();
	}
	
	
	@Test(priority = 7)
	public void userCanPrintInvoice() throws InterruptedException {
		
		order1 = new Order_details_page(driver);
		Thread.sleep(2000);
		order1.printInvoice();
		Thread.sleep(2000);
		
	}
	
}
