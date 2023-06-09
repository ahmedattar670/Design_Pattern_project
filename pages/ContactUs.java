package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends PageBase{

	public ContactUs(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement FullName;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Enquiry")
	WebElement Enquiry;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement Submitbtn;
	
	
	@FindBy(css = "div.result")
	public WebElement SuccessMsg;
	
	public void sendEnquiry(String Name, String Emailo,String TheEnquiry ) {
	
		setTextOnTextBox(FullName, Name);
		setTextOnTextBox(Email, Emailo);
		setTextOnTextBox(Enquiry, TheEnquiry);
		clickbtn(Submitbtn);
	}
	
	
	
	

}
