package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServicePage extends BasePage {
	
	String CUSTOMER_SERVICE_URL ="https://www.amazon.com/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice";

	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_customerservice']")
	private WebElement customerSevicePageLink;
	
	@FindBy(xpath = "//div[@id='hub-gateway-app-unauth']/div/div/h1")
	private WebElement customerSeviceHeader;
	
	
	// Initializing the Page Objects:
		public CustomerServicePage() {
			PageFactory.initElements(driver, this);
		}

		public void clickCustomerSevicePageLink() throws Exception{

			customerSevicePageLink.click();
			Thread.sleep(2000);
		}
				
		
		public void checkCustomerSevicePageUrl() throws Exception{

		    String currentUrl = driver.getCurrentUrl();
		    System.out.println("c "+currentUrl);
		    System.out.println("c1 "+CUSTOMER_SERVICE_URL);
		    if (!currentUrl.trim().equals(CUSTOMER_SERVICE_URL)) {
		    	throw new Exception("Wrong url "+currentUrl); 
		    	}
		}
				
		
		public void checkCustomerSevicePageHeader() throws Exception{
				
			   
			    String headerCustomerService = customerSeviceHeader.getText();
			    if (!headerCustomerService.equals("Welcome to Amazon Customer Service"))
			    	throw new Exception("Wrong title"); 
			   
		}
	
}
