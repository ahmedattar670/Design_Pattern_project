package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	
	public PageBase(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	protected static void clickbtn(WebElement element) {
		
		element.click();
	}
	
	protected static void setTextOnTextBox(WebElement textBox, String text ) {
		
		textBox.sendKeys(text);
		
	}
	
	public void ScrolltoBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}
	
	public void clearText(WebElement textbox) {
		textbox.clear();
	}

}
