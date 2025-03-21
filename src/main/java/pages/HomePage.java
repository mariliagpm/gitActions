package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.Browser;


public class HomePage extends BasePage{
	
	String HOME_PAGE_URL = "https://www.amazon.com/ap/signin/ref=cart_empty_sign_in?openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fcart%3Fapp-nav-type%3Dnone%26dc%3Ddf&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
			
	@FindBy(xpath = "//i[@role='presentation']")
	private WebElement logo;
	
	@FindBy(xpath = "//input[@data-action-type='DISMISS']")
	private WebElement dismissBrAmazon;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToHomePage() throws InterruptedException { 
		    driver.manage().window().maximize();
		    Thread.sleep(2000);
		    driver.get(HOME_PAGE_URL);
		    logo.click();
			if(driver.findElements(By.xpath("//input[@data-action-type='DISMISS']")).size()>0)	
				dismissBrAmazon.click();	
		  
	}
}
