package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendObject;
import pages.HomePage;
import pages.MyAccount_change_pass;
import pages.Product_details;
import pages.RegistrationPage;
import pages.Search_page;
import pages.UserLogin;

public class EmailFrirendTest extends TestBase{
	
	//1- Register
	//2- login with registered data
	//3- search for product with auto suggest
	//4- email to your friend
	
	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;
	MyAccount_change_pass My_acc;
	Product_details product;
	EmailFriendObject EmailObject;
	Search_page search_object;
	Product_details product1;
	String Fname = "ahmed";
	String Lname = "Eslam";
	String email = "ahmed1123@gmail.com";
	String Old_password = "1234567";
	
	@Test(priority = 1)
	public void UserCanRegister() {
		
		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration(Fname,Lname,email, Old_password);
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
		loginObject.userLoginUser(email,Old_password);
	}
	
	@Test(priority = 4)
	public void test_searching() {

		search_object = new Search_page(driver);
		product = new Product_details(driver);
		product1 = new Product_details(driver);
		
		search_object.SearchByAutoSuggest("Mac");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		product.OpenEmailFriendPage();
			
	}

	
	@Test(priority = 5)
	public void testEmailAFriend() {
		
		EmailObject = new EmailFriendObject(driver);
		EmailObject.SendProductToFriend("Mohamed@gmail.com", "This is a fine product");
		Assert.assertTrue(EmailObject.successMsg.getText().contains("Your message has been sent."));	
	}
	
	

}
