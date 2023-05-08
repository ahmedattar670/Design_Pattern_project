package DataDrivenClasses;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.RegistrationPage;
import pages.UserLogin;
import tests.TestBase;

public class testUserRegistrationWithDDTwithCSVfile extends TestBase {

	HomePage homeObject;
	RegistrationPage RegisterObject;
	UserLogin loginObject;

	CSVReader reader;
	
	@Test(priority = 1)
	public void UserCanRegister() throws Exception, IOException {

		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		
		while((csvCell = reader.readNext())!=null) {
			String fname = csvCell[0];
			String lname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
		
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


}
