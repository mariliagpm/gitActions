package selenium;
 
import static org.junit.Assert.*;  

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import support.Browser;
 

public class TestSteps {

	WebDriver driver;

	@After
	public void quitBrowser() {
	  driver.quit();
	}
	 
	@Before
	public void launchBrowser() throws InterruptedException {
		System.out.println("First Step");
	    driver = Browser.launch();
	    driver.manage().window().maximize();

	    driver.get("https://www.hoyts.co.nz/");
	    Thread.sleep(5000);
	}
	 
	 
	@Given("the user is in the home page")
	public void the_user_is_in_the_home_page() throws InterruptedException { 
		Thread.sleep(5000);
	}
	
	@When("the user click at Log in button")
	public void the_user_click_at_log_in_button() throws InterruptedException {
	   driver.findElement(By.xpath("//div[@id=\"header-profile\"]//span")).click();
	   Thread.sleep(5000);
	  }
	
	@Then("the login modal will be opened")
	public void the_login_modal_will_be_opened() {
	   
	}
	
	@When("the user type the right username {string} and the right password {string}")
	public void the_user_type_the_right_username__and_the_right_password_(String username, String password) throws InterruptedException {
	 
		
				 driver.findElement(By.xpath(("(//div[contains(@class, \"sign-in__fields\")]//input[contains(@class, \"form-placeholder__input\")])[1]"))).sendKeys(username);
				 Thread.sleep(5000);
				 driver.findElement(By.xpath(("(//div[contains(@class, \"sign-in__fields\")]//input[contains(@class, \"form-placeholder__input\")])[2]"))).sendKeys(password);
				 Thread.sleep(5000);
	}
	
	@When("the user type the wrong username {string} and the wrong password {string}")
	public void the_user_type_the_wrong_username__and_the_wrong_password_(String username, String password) throws InterruptedException {
	 
		
				 driver.findElement(By.xpath(("(//div[contains(@class, \"sign-in__fields\")]//input[contains(@class, \"form-placeholder__input\")])[1]"))).sendKeys(username);
				 Thread.sleep(5000);
				 driver.findElement(By.xpath(("(//div[contains(@class, \"sign-in__fields\")]//input[contains(@class, \"form-placeholder__input\")])[2]"))).sendKeys(password);
				 Thread.sleep(5000);
	}
	
	@When("the user click at sign button")
	public void the_user_click_at_sign_button() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[contains(@class, \"form-button\")]")).click();
		 Thread.sleep(5000);

	}
	
	 
	
	@Then("user will be redirect to the dashboard page")
	public void user_will_be_redirect_to_the_dashboard_page() {
	    String url =  driver.getCurrentUrl();
	    assertEquals(url,  "https://www.hoyts.co.nz/");  

	}

	 

	@Then("the user will see a error message {string} displayed in the screen")
	public void the_user_will_see_a_error_message_displayed_in_the_screen(String errorMessageString) {
		String errorMessage = driver.findElement(By.xpath("//div[contains(@class, \"sign-in__alert\")]//span[contains(@class, \"alert__text\")]")).getText();
		assertEquals(errorMessageString,  errorMessage);  		
	}



	 
	  
	
	@When("the user searches by an invalid movie {string} in the search bar")
	public void the_user_searchs_by_a_invalid_movie_in_the_search_bar(String string) throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@class, \"header__search-input\")]")).sendKeys(string);
		 Thread.sleep(5000);
	}

	 
	@When("the user searches by a valid movie {string} in the search bar")
	public void the_user_searchs_by_a_valid_movie_in_the_search_bar(String string) throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@class, \"header__search-input\")]")).sendKeys(string);
		 Thread.sleep(2000);
	}




	
	@Then("the user will the see a list of movies containing the name typed")
	public void the_user_will_the_see_a_list_of_movies_containing_the_name_typed() {
	}
	
	@When("the user click at the first movie of the list")
	public void the_user_click_at_the_first_movie_of_the_list() throws InterruptedException {
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[contains(@class, \"header__search-title\")])[1]")).click();
	}
	
	@Then("the user will be redirect to a page contains more information about the movie {string}  choosen")
	public void the_user_will_be_redirect_to_a_page_contains_more_information_about_the_movie_choosen(String movieName) throws InterruptedException {
		 	Thread.sleep(3000);
		 	String url =  driver.getCurrentUrl();
		 	movieName=movieName.replace(" ", "-");
		    assertEquals(true, url.contains(movieName.toLowerCase()));  
	}
  

	@Then("the user will see a {string} in the search bar")
	public void the_user_will_see_a_in_the_search_bar(String message) {
		String error =  driver.findElement(By.xpath("//span[contains(@class, \"header__search-heading\")]")).getText();
		assertEquals(message,  error);  		
	}






 
	 

}
