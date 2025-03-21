package pages;
 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MenuAllPage extends BasePage {

	String TODAY_DEAL_URL = "https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb";
	
	@FindBy(xpath = "//a[@data-csa-c-slot-id='HamburgerMenuDesktop']")
	private WebElement menuAllLink;
	
	@FindBy(xpath = "//div[contains(@class, 'hmenu-item')]")
	private List<WebElement> listOfMenus;
	
	
	// Initializing the Page Objects:
		public MenuAllPage() {
			PageFactory.initElements(driver, this);
		}

		public void clickMenuAllLink() throws Exception{

			menuAllLink.click();  
		}
				
		
		public void checkLateralMenuList() throws Exception{
			
			// explicit wait - to wait for the compose button to be click-able
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'hmenu-item')]")));

			listOfMenus = driver.findElements(By.xpath("//div[contains(@class, 'hmenu-item')]"));
			if(listOfMenus.size()==0) {
				throw new Exception("Lateral menu was not loaded correctly");
			}
			if(listOfMenus.size()>0) {
				 Assert.assertEquals(listOfMenus.get(0).getText(),"Digital Content & Devices");
				 Assert.assertEquals(listOfMenus.get(1).getText(),"Shop by Department");
				 Assert.assertEquals(listOfMenus.get(2).getText(),"Programs & Features");
				 Assert.assertEquals(listOfMenus.get(3).getText(),"Help & Settings");
				 
			}
		    
		}
				
		
		 
	
}
