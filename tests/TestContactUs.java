package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUs;
import pages.HomePage;

public class TestContactUs extends TestBase{
	
	HomePage homeObject;
	ContactUs contactObject;
	String myname = "Ahmed";
	String mymail = "ahmed@gmail.com";
	String Enquiry = "What is that?";
	
	@Test
	public void SendEnquiry() {
		
		homeObject = new HomePage(driver);
		contactObject = new ContactUs(driver);
		
	  	homeObject.ScrollDown();
		homeObject.PressOnContactUs();
		
		contactObject.sendEnquiry(myname, mymail, Enquiry);
		Assert.assertTrue(contactObject.SuccessMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}

}
