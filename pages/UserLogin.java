package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogin extends PageBase {

	public UserLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement emailtxt;
	
	@FindBy(id = "Password")
	WebElement passwordtxt;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginbtn;
	
	@FindBy(linkText = "Log out")
    public WebElement logOutbtn;
	
	@FindBy(linkText = "My account")
	public WebElement MyAccount;
	
	public void userLoginUser(String emailtxtbox, String Passtxtbox)
	{
		setTextOnTextBox(emailtxt, emailtxtbox);
		setTextOnTextBox(passwordtxt, Passtxtbox);
		clickbtn(loginbtn);
	}
	
	public void Open_MyAccount() {
		clickbtn(MyAccount);
	}

}
