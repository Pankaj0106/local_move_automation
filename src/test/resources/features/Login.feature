Feature: Customer Authentication

Scenario Outline: Verify customer can log in and log out successfully
  	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login  	
  	Then User verify toast message "Login successful!"
  	When User clicks logout
  	Then User verify toast message "You've been logged out successfully!"
	Examples:
	|	Email			  | Password	|
	|newtest123@gmail.com | 123456		|	
	
Scenario Outline: Verify customer cannot login with incorrect password
  	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login  	
  	Then User verify toast message "Invalid email or password"
	Examples:
	|	Email			  | Password	|
	|newtest123@gmail.com | 1234567		|	
		
Scenario Outline: Verify customer cannot login with incorrect email
  	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
  	Then User verify toast message "Invalid email or password"
	Examples:
	|	Email			  | Password	|
	|test788887@gmail.com | 1234567		|





