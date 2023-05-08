package DataDrivenClasses;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class testUserRegistrationWithDataProvider extends TestBase {

	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"david","alaba","david9e@gmail.com","4647853589576"},
			{"paulo","dybala","paulo@gmail.com","90072343544589"},
			{"pauluro","dyb","paulftigfko@gmail.com","9007233434433"}
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
