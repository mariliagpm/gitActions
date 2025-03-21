package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodayDealsPage extends BasePage {

	String TODAY_DEAL_URL = "https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb";
	
	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_gb']")
	private WebElement todayDealsLink;
	
	@FindBy(xpath = "//div[@data-id='deals-header']/div/div/h1")
	private WebElement todayDealsHeader;
	
	
	// Initializing the Page Objects:
		public TodayDealsPage() {
			PageFactory.initElements(driver, this);
		}

		public void clickTodaysDealLink() throws Exception{

		    todayDealsLink.click();
		    Thread.sleep(2000);
		}
				
		
		public void checkTodaysDealUrl() throws Exception{

		    String currentUrl = driver.getCurrentUrl();
		    if (!currentUrl.equals(TODAY_DEAL_URL))
		    	throw new Exception("Wrong url"); 
		}
				
		
		public void checkHeaderTodaysDeal() throws Exception{
				 
			    String headerTodayDeals = todayDealsHeader.getText();
			    if (!headerTodayDeals.equals("Today's Deals"))
			    	throw new Exception("Wrong title"); 
			   
		}
	
}
