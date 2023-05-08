package DataDrivenClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class testUserRegistrationWithExcelFile extends TestBase {

	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;

	@DataProvider(name = "ExcelData")
	public static Object[][] userData() throws IOException{
		
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}

	@Test(priority = 1,dataProvider = "ExcelData")
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
