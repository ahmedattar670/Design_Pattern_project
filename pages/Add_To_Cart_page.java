package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_To_Cart_page extends PageBase{

	public Add_To_Cart_page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productName;
	
	@FindBy(id = "itemquantity11224")
	public WebElement quantity_txt;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement total_price;
	
	@FindBy(css = "button.remove-btn")
	public WebElement remove_btn;
	
	@FindBy(id = "updatecart")
	public WebElement updateCart_btn;
	
	@FindBy(css = "div.no-data")
	public WebElement NoDateMessage;
	
	public void RemoveProduct() {
		clickbtn(remove_btn);
	}

	public void update_cart() {
		clickbtn(updateCart_btn);
	}
	
	public void updateQuantityInCart(String quantity) {
		clearText(quantity_txt);
		setTextOnTextBox(quantity_txt, quantity);
		clickbtn(updateCart_btn);
	}

	
	
	

}
