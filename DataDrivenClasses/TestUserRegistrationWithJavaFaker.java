package DataDrivenClasses;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class TestUserRegistrationWithJavaFaker extends TestBase {
	
	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;
	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Test(priority = 1)
	public void UserCanRegister() {
		
		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration(firstName,lastName,email,password);
		System.out.println(firstName+" "+lastName+" "+email+" "+password);
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
		
		loginObject.userLoginUser(email,password);
		Assert.assertTrue(loginObject.logOutbtn.isDisplayed());
	}
	
	
	

}
