package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;

public class TestUserRegistration extends TestBase {
	
	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;
	
	@Test(priority = 1)
	public void UserCanRegister() {
		
		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration("sol","lal","solaa.ag@gmail.com", "12345678");
		Assert.assertTrue(RegisterObject.successtxt.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "UserCanRegister")
	public void UserCanLogout() {
		
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@Test(dependsOnMethods = "UserCanLogout")
	public void UserCanLogin() {
		
		homeObject.clickLoginbtn();
		loginObject = new UserLogin(driver);
		
		loginObject.userLoginUser("solaa.ag@gmail.com","12345678");
		Assert.assertTrue(loginObject.logOutbtn.isDisplayed());
	}
	
	
	

}
