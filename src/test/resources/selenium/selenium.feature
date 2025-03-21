
@tag
Feature: Amazon 
   
    Scenario: Check the menu All
			Given the user is in the home page 
			And the user clicks in the all menu link
			Then the user will see the lateral menu open
		 
		   	   
	  Scenario: Check the menu Today's Deal 
			Given the user is in the home page 
			And the user clicks in the todays deal link
			Then the user will go to today deal url 
			And the user will see the header of today deals page
	 
	  Scenario: Check the menu Customer Service
			Given the user is in the home page 
			And the user clicks in the customer service link
			Then the user will go to customer service url 
			And the user will see the header of customer service page
		   	   
	
	  Scenario: Check the menu Registry
			Given the user is in the home page 
			And the user clicks in the registry link
			Then the user will go to the registry url 
			And the user will see the header of registry page
   
   Scenario Outline: Check autocomplete seach 
    Given the user is in the home page  
    When the user send a product to search using first parameter "<productName>"
		Then the user will see the product to buy as "<productNameSecond>" and the user will click on it
		And the user will be redirect to the product chose url
		
	  Examples:
	    | productName    | productNameSecond |
	    | school         | supplies   |
	    | party				   | plates     |
    
 
			   	   