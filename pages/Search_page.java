package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_page extends PageBase{

	public Search_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement search_txtBox;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> item_list;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement search_btn;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement the_actual_product;
	
	public void search_for_item (String product_name) {
		
		setTextOnTextBox(search_txtBox, product_name);
		clickbtn(search_btn);
	}
	
	public void choose_the_product() {
		clickbtn(the_actual_product);
	}
	
	public void SearchByAutoSuggest(String txtSearch) {
		setTextOnTextBox(search_txtBox, txtSearch);
		item_list.get(0).click();
	}
	
	
	
}
