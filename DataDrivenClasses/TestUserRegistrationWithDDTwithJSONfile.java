package DataDrivenClasses;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import data.JsonDataReader;
import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class TestUserRegistrationWithDDTwithJSONfile extends TestBase {

	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;

	@Test(priority = 1)
	public void UserCanRegister() throws FileNotFoundException, IOException, ParseException {

		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver);
		RegisterObject = new RegistrationPage(driver);
		homeObject.clickRegisterbtn();
		RegisterObject.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(RegisterObject.successtxt.getText().contains("Your registration completed"));
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject.clickLoginbtn();
		loginObject = new UserLogin(driver);
		loginObject.userLoginUser(jsonReader.email,jsonReader.password);
		Assert.assertTrue(loginObject.logOutbtn.isDisplayed());
		loginObject.logOutbtn.click();
	}

	
}
