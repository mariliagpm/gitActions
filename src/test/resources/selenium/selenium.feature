
@tag
Feature: Testing
   

		   	   
		   	   
	 Scenario Outline: Search a movie using a valid name 
		Given the user is in the home page
		When the user searches by a valid movie "<movieName>" in the search bar 
		Then the user will the see a list of movies containing the name typed	
		When the user click at the first movie of the list 
		Then the user will be redirect to a page contains more information about the movie "<movieName>"  choosen
		
	Examples:
		    | movieName       	  	  |   
		    |  Harry Potter           |  
		   	   
	
	
	 Scenario Outline: Search a movie using an invalid name 
		Given the user is in the home page
		When the user searches by an invalid movie "<movieName>" in the search bar  
		Then the user will see a "<message>" in the search bar
		
	Examples:
		    | movieName       	  	   |   message|  
 	      |  Harry213                |  	   	    Sorry, we couldn't find any results |
		   	   
		   	   
  Scenario Outline: Login with valid username and pwd 
		Given the user is in the home page 
		When the user click at Log in button
		Then the login modal will be opened 
		When the user type the right username "<username>" and the right password "<password>"
		And the user click at sign button 
		Then user will be redirect to the dashboard page 
		   
	 Examples:
		    | username       	  	                 |  password  |  
		    |   mariliagpm@hotmail.com             | Tester03  |  
		   
		   
	 Scenario Outline: Login with invalid username and pwd 
		Given the user is in the home page
		When the user click at Log in button
		Then the login modal will be opened 
		When the user type the right username "<username>" and the right password "<password>"
		And the user click at sign button  
		Then the user will see a error message "<message>" displayed in the screen   
	 Examples:
		    | username       	  	                 |  password  |  message |
		    |   mariliagpm3@hotmail.com             | Tester03  |  Sorry, that email or password seems to be incorrect. Please try again or contact us			   |
		   	   
		