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

public class SearchingItemPage extends BasePage {
 
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement inputProduct;
	
	@FindBy(xpath = "//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"]")
	private List<WebElement> listOfProductByFirstWordsSearched;
	
	@FindBy(xpath = "//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"]/span")
	private List<WebElement> listOfProductSecondPartSearched;
	
	private String firstPartProduct="";

	private String secondPartProduct="";
	
	// Initializing the Page Objects:
		public SearchingItemPage() {
			PageFactory.initElements(driver, this);
		}

		public void sendInputProduct(String product) throws Exception{
			firstPartProduct=product;
			inputProduct.sendKeys(product);
		}
				
		
		public void checkResultSecondPart (String secondPart) throws Exception{
			
			boolean stringFound=false;
			secondPartProduct= secondPart;
			Thread.sleep(3000);
  
			listOfProductByFirstWordsSearched = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
			listOfProductSecondPartSearched = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']/span"));
			List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='s-suggestion-container']")); 
			
			 
		 	
			if(listOfProductByFirstWordsSearched.size()!=10) {
				throw new Exception("Lateral menu was not loaded correctly");
			}
		 
				for(int i = 0 ; i<listOfProductSecondPartSearched.size();i++) {
				 if(listOfProductSecondPartSearched.get(i).getText().trim().equals(secondPart.trim())){
					 stringFound = true;
					 listOfProducts.get(i).click();
					 break;
					 
				 } }
				 if(!stringFound)
					 throw new Exception("String was not found");
				
			 
		    
		}    
				
		public void checkUrlResult() throws Exception {
			
			String cUrl  = driver.getCurrentUrl();
			
			if(!cUrl.contains(""+firstPartProduct+"+"+secondPartProduct)) {
				throw new Exception("User redirect to wrong url");
			}
		}
		 
	
}
