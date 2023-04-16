package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_change_pass extends PageBase{

	public MyAccount_change_pass(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement Change_password;
	
	@FindBy(id = "OldPassword")
	WebElement old_pass;
	
	@FindBy(id = "NewPassword")
	WebElement new_pass;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirm_pass;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement change_pass_btn;
	
	@FindBy(css = "p.content")
	public WebElement success_notfication;
	
	public void Change_password (String old_one, String new_one) {
		
		setTextOnTextBox(old_pass, old_one);
		setTextOnTextBox(new_pass, new_one);
		setTextOnTextBox(confirm_pass, new_one);
		clickbtn(change_pass_btn);
	}

	public void open_change_pass() {
		clickbtn(Change_password);
	}
	
}
