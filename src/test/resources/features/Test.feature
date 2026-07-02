Feature: Test

Scenario Outline: Verify user is able to successfully Add New Customer
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
	Then User navigate to Companies section
	And User clicks on Add Customer Button
	Then Fill details for Step1
		|CompanyName 	|	A3	 	|
		|CompanyEmail	| a3@gmail.com	|
		|Password		|	123456	 	|
		|FirstName		|	Test	 	|
		|LastName		|	123		 	|
		|Phone			| 9341037274 	|
		|Subscription 	|Jobs - Founder	|
	Then User clicks on the Next Step
	Then User Fill details foe Step2
		|Postcode	|  Ab100	|
		|City		|  Testing	|
		|Address	|  Test		|
	And User clicks on Register Company button
	Then the company "A3" should be visible in the company list
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|
	
