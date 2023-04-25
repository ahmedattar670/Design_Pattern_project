package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Checkout_page extends PageBase {

	public Checkout_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement Email;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressOne;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement nextStep_btn;
	
	@FindBy(id = "shippingoption_0")
	WebElement shippingGround;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement shipping_btn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement checkPaymentMethod;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement payment_btn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInfo_btn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirm_btn;
	
	@FindBy(tagName = "h1")
	public WebElement Thankyoulbl;
	
	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetailsPage;
	
	@FindBy(css = "button.button-1.order-completed-continue-button")
	public WebElement success_btn;
	
	@FindBy(linkText = "Log out")
	public WebElement logOut_btn;
	
	
	public void userFillCheckoutDetails(String fname, String lname, String email1, String yourCity, String firstAddress, String pCode, String phoneNum) {
		
		clearText(firstName);
		setTextOnTextBox(firstName, fname);
		clearText(lastName);
		setTextOnTextBox(lastName, lname);
		clearText(Email);
		setTextOnTextBox(Email, email1);
		select = new Select(country);
		select.selectByVisibleText("Egypt");
		setTextOnTextBox(city, yourCity);
		setTextOnTextBox(addressOne, firstAddress);
		setTextOnTextBox(zipCode, pCode);
		setTextOnTextBox(phoneNumber, phoneNum);
		clickbtn(nextStep_btn);
		clickbtn(shippingGround);
		clickbtn(shipping_btn);
		clickbtn(checkPaymentMethod);
		clickbtn(payment_btn);
		clickbtn(paymentInfo_btn);
		clickbtn(confirm_btn);
		
	}
	
	public void OpenOrderDetailsPage() {
		clickbtn(orderDetailsPage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
