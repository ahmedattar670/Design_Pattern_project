package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	private WebElement clear_list_btn;
	
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCols;
	
	@FindBy(css = "div.no-data")
	public WebElement NoDataMessage;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProduct;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement SecondProduct;
	
	public void ClearAllProducts() {
		clickbtn(clear_list_btn);
	}
	
	public void CompareTheProducts() {
		
		System.out.println(allRows.size());
		// display all the data
		for(WebElement row: allRows) {
		
			System.out.println(row.getText()+"\t");
			
			for(WebElement col: allCols) {
				
				System.out.println(col.getText()+"\t");
				
			}
		}
		
	}
	
	
	

}
