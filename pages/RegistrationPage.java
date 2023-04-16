package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {


	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement radioBtnMale;

	@FindBy(id = "FirstName")
	WebElement txtFname;
	
	@FindBy(id = "LastName")
	WebElement txtLname;
	
	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(id = "ConfirmPassword")
	WebElement txtConfirmPassword;
	
	@FindBy(id = "register-button")
	WebElement btnRegister;
	
	@FindBy(css = "div.result")
	public WebElement successtxt;
	
	
	public void userRegistration(String Fname, String Lname, String email, String password)
	{
		clickbtn(radioBtnMale);
		setTextOnTextBox(txtFname, Fname);
		setTextOnTextBox(txtLname, Lname);
		setTextOnTextBox(txtEmail, email);
		setTextOnTextBox(txtPassword, password);
		setTextOnTextBox(txtConfirmPassword, password);
		clickbtn(btnRegister);
	}
	
	
	

	
}
