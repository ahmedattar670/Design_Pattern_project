package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Whishlist_page extends PageBase{

	public Whishlist_page(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css = "h1")
	public WebElement header;
	
	@FindBy(css = "td.product")
	public WebElement ProductCell;
	
	@FindBy(css = "button.remove-btn")
	public WebElement RemovefromWhishlist;
	
	@FindBy(css = "div.no-data")
	public WebElement successMsg;
	
	public void Remove_Product_from_cart() {
		clickbtn(RemovefromWhishlist);
	}
	
	
	
	
	
}
