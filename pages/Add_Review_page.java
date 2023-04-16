package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_Review_page extends PageBase {

	public Add_Review_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement Review_title;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement Review_text;
	
	@FindBy(id = "addproductrating_4")
	WebElement product_rating;

	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submit_review;
	
	@FindBy(css = "div.result")
	public WebElement result;
	
	public void add_review(String title,String text) {
		setTextOnTextBox(Review_title, title);
		setTextOnTextBox(Review_text, text);
		clickbtn(product_rating);
		clickbtn(submit_review);
	}
	
	
	
	
	
	
}
