package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistryPage extends BasePage {

	String TODAY_DEAL_URL = "https://www.amazon.com/registries?ref_=nav_cs_registry&ref_=nav_cs_registry";
	
	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_registry']")
	private WebElement todayDealsLink;
	
	@FindBy(xpath = "//a[@class='gr-subnav-registry__logo']")
	private WebElement todayDealsHeader;
	
	
	// Initializing the Page Objects:
		public RegistryPage() {
			PageFactory.initElements(driver, this);
		}

		public void clickTodaysDealLink() throws Exception{

		    todayDealsLink.click();
		}
				
		
		public void checkTodaysDealUrl() throws Exception{

		    String currentUrl = driver.getCurrentUrl();
		    if (!currentUrl.equals(TODAY_DEAL_URL))
		    	throw new Exception("Wrong url"); 
		}
				
		
		public void checkHeaderTodaysDeal() throws Exception{
				
			    Thread.sleep(2000);
			    String headerTodayDeals = todayDealsHeader.getText();
			    if (!headerTodayDeals.trim().equals("registry & gifting"))
			    	throw new Exception("Wrong title"); 
			   
		}
	
}
