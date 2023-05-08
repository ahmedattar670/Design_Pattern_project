package DataDrivenClasses;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class testUserRegistrationWithDataProvider2andFakelib extends TestBase {

	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;

	static Faker fakeData = new Faker();
	static String firstName = fakeData.name().firstName();
	static String lastName = fakeData.name().lastName();
	static String email = fakeData.internet().emailAddress();
	static String password = fakeData.number().digits(8).toString();
	
	static String firstName1 = fakeData.name().firstName();
	static String lastName1 = fakeData.name().lastName();
	static String email1 = fakeData.internet().emailAddress();
	static String password1 = fakeData.number().digits(8).toString();
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{firstName,lastName,email,password},
			{firstName1,lastName1,email1,password1},
		};

	}

	@Test(priority = 1,dataProvider = "testData")
	public void UserCanRegister(String fname, String lname, String email, String password) {

		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(RegisterObject.successtxt.getText().contains("Your registration completed"));
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject.clickLoginbtn();
		loginObject = new UserLogin(driver);
		loginObject.userLoginUser(email,password);
		Assert.assertTrue(loginObject.logOutbtn.isDisplayed());
		loginObject.logOutbtn.click();
	}


}
