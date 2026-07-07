Feature: Test	

Scenario Outline: Verify user is able to successfully Delete Customer
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Navigates to Customers section
    When User creates a new customer with following details
      | FullName | P00		           |
      | Email    | p000@gmail.com      |
      | Country  | GB +44              |
      | Phone    | 70000600045         |
      | Password | Test@123            |  
    And the user clicks the Create Customer button
    Then User verify toast message "User created successfully"
    Then the customer "p000@gmail.com" should be present in the customer grid as "true"
	When the user clicks the Delete button for the customer with email "p000@gmail.com"
	And the user clicks the "Delete" button
	Then User verify toast message "User and associated data soft-deleted successfully"
	And Refresh the page
	Then User verify customer "p000@gmail.com" presence is "false"
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		| 
