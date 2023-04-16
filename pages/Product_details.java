package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_details extends PageBase {

	public Product_details(WebDriver driver) {
		super(driver);
	}

	@FindBy(tagName = "h1")
	public WebElement actual_product;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement Email_a_friend_btn;
	
	@FindBy(id = "price-value-4")
	public WebElement price;
	
	@FindBy(linkText = "Add your review")
	WebElement Add_your_review;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement Add_To_WhishList;
	
	@FindBy(linkText = "wishlist")
	WebElement WhishList_page;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	public WebElement Compare_products_btn;
	
	@FindBy(linkText = "product comparison")
	public WebElement Comparison_page;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	@FindBy(linkText = "shopping cart")
	WebElement Cart_page;
	
	public void OpenEmailFriendPage() {
		clickbtn(Email_a_friend_btn);
	}

	public void OpenReviewPage() {
		clickbtn(Add_your_review);
	}
	
	public void addToWhishList() {
		clickbtn(Add_To_WhishList);
	}

	public void OpenWhishListPage() {
		clickbtn(WhishList_page);
	}
	
	public void Add_to_compare_list() {
		clickbtn(Compare_products_btn);
	}

	public void Open_Comparison_Page() {
		clickbtn(Comparison_page);
	}
	
	public void add_to_cart() {
		clickbtn(AddToCartBtn);
	}
	
	public void OpenCartPage() {
		clickbtn(Cart_page);
	}
	
	
}
