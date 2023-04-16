package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendObject extends PageBase{

	public EmailFriendObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement firendMail;
	
	@FindBy(id = "YourEmailAddress")
	WebElement MyMail;
	
	@FindBy(id = "PersonalMessage")
	WebElement TheMessage;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement SendMail_btn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void SendProductToFriend(String YourFriendMail, String Message) {
		
		setTextOnTextBox(firendMail, YourFriendMail);
		setTextOnTextBox(TheMessage, Message);
		clickbtn(SendMail_btn);
	}
	
	
	

}
