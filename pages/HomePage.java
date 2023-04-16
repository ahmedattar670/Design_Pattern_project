package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registerbtn;
	
	@FindBy(linkText = "Log in")
	WebElement loginbtn;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUs;
	
	
	@FindBy(id = "customerCurrency")
	WebElement Change_currency;
	
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NoteBooks;
	
	public void clickRegisterbtn() {
		clickbtn(registerbtn);
	}
	
	public void clickLoginbtn() {
		clickbtn(loginbtn);
	}
	
	public void ScrollDown() {
		ScrolltoBottom();
	}
	
	public void PressOnContactUs() {
		clickbtn(ContactUs);
	}
	
	public void ChangeCurrency() {
		select=new Select(Change_currency);
		select.selectByVisibleText("Euro");
	}
	
	public void SelectNoteBooks() {
		
		action
		.moveToElement(computerMenu)
		.moveToElement(NoteBooks)
		.click()
		.build()
		.perform();
		
	}
	
	

}
