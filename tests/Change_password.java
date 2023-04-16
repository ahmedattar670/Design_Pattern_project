package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccount_change_pass;
import pages.RegistrationPage;
import pages.UserLogin;

public class Change_password extends TestBase {
	
	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;
	MyAccount_change_pass My_acc;
	String Fname = "ahmed";
	String Lname = "Eslam";
	String email = "ahmed123@gmail.com";
	String Old_password = "1234567";
	String New_password = "7654321";
	
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
		loginObject.Open_MyAccount();
	}
	
	
	@Test(priority = 4)
	public void change_my_password() throws InterruptedException {
		
		My_acc = new MyAccount_change_pass(driver);
		My_acc.open_change_pass();
		My_acc.Change_password(Old_password, New_password);
		Assert.assertTrue(My_acc.success_notfication.getText().contains("Password was changed"));
		Thread.sleep(2000);
		
	}
	

}
