package selenium;
  

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.CustomerServicePage;
import pages.HomePage;
import pages.MenuAllPage;
import pages.RegistryPage;
import pages.SearchingItemPage;
import pages.TodayDealsPage; 
 

public class TestSteps {

	TodayDealsPage todayDels = new TodayDealsPage();
	HomePage homePage = new HomePage();
	CustomerServicePage cs = new CustomerServicePage();
	RegistryPage registryPage = new RegistryPage();
	MenuAllPage menuAllPage = new MenuAllPage();
	SearchingItemPage searchingPage = new SearchingItemPage();
	
	static WebDriver driver = BasePage.driver;	
	
	public void screenShot(Scenario scenario) {
		 if (scenario.isFailed()) {
		        try {
		            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		            String testName = scenario.getName();
		            scenario.attach(screenshot, "image/png",testName); 
		        } catch (WebDriverException wde) {
		            System.err.println(wde.getMessage());
		        } catch (ClassCastException cce) {
		            cce.printStackTrace();
		            }
		        }
	} 
	 
	@AfterAll
	public static void before_or_after_all() {

		 driver.quit();
		
	}
	 
	@Before
	public void launchBrowser() throws Exception {
 	    
	
	}
	 


	@Given("the user is in the home page")
	public void the_user_is_in_the_home_page() throws InterruptedException {
		homePage.goToHomePage();
	}


	@Given("the user clicks in the todays deal link")
	public void the_user_clicks_in_the_todays_deal_link() throws Exception {
		todayDels.clickTodaysDealLink();
	}
	
	 
	
	@Then("the user will see the header of today deals page")
	public void the_user_will_see_the_header_of_today_deals_page() throws Exception {
		 todayDels.checkHeaderTodaysDeal();
	} 
	
	
		@Then("the user will go to today deal url")
		public void the_user_will_go_to_today_deal_url() throws Exception {
			 todayDels.checkTodaysDealUrl();
		}




	@Given("the user clicks in the customer service link")
	public void the_user_clicks_in_the_customer_service_link() throws Exception {
	     cs.clickCustomerSevicePageLink();
	}
	
	@Then("the user will go to customer service url")
	public void the_user_will_go_to_customer_service_url() throws Exception {
			cs.checkCustomerSevicePageUrl();
	}
	
	@Then("the user will see the header of customer service page")
	public void the_user_will_see_the_header_of_customer_service_page() throws Exception {
		cs.checkCustomerSevicePageHeader();
	}

	
	@Given("the user clicks in the registry link")
	public void the_user_clicks_in_the_registry_link() throws Exception {
		registryPage.clickTodaysDealLink();
	}
	
	@Then("the user will go to the registry url")
	public void the_user_will_go_to_the_registry_url() throws Exception {
	     registryPage.checkTodaysDealUrl();
	}
	
	
	@Then("the user will see the header of registry page")
	public void the_user_will_see_the_header_of_registry_page() throws Exception { 
		registryPage.checkHeaderTodaysDeal();
	}

	@Given("the user clicks in the all menu link")
	public void the_user_clicks_in_the_all_menu_link() throws Exception {
		menuAllPage.clickMenuAllLink();
	}
	@Then("the user will see the lateral menu open")
	public void the_user_will_see_the_lateral_menu_open() throws Exception {
		menuAllPage.checkLateralMenuList();
	}
	 
		  
	
	@When("the user send a product to search using first parameter {string}")
	public void the_user_send_a_product_to_search_product_name_first_part_as_a_first_parameter(String firstPart) throws Exception {
		searchingPage.sendInputProduct(firstPart);
	}
	
	
	@When("the user will see the product to buy as {string} and the user will click on it")
	public void the_user_will_see_the_product_to_buy_as_and_the_user_will_click_on_it(String secondPart) throws Exception {
		searchingPage.checkResultSecondPart(secondPart);
	}

	
	 
	
	@Then("the user will be redirect to the product chose url")
	public void the_user_will_be_redirect_to_the_product_chose_url() throws Exception {
	    searchingPage.checkUrlResult();
	}
	
	 

}
