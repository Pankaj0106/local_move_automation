Feature: Customer Management

Scenario Outline: Verify user is able to successfully Add New Customer
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Navigates to Customers section
    When User creates a new customer with following details
      | FullName | John Smith            |
      | Email    | Testing88@gmail.com  |
      | Country  | GB +44                |
      | Phone    | 98765433218           |
      | Password | Test@123              |  
    Then User verify toast message "User created successfully"
  	
  	Examples:
		|	Email			  | Password	| 
		|admin@localmoves.com | 1234		|


Scenario Outline: Verify user is not able to Add New Customer with same data
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Navigates to Customers section
    When User creates a new customer with following details
      | FullName | John Smith            |
      | Email    | Testing88@gmail.com  |
      | Country  | GB +44                |
      | Phone    | 9876543218            |
      | Password | Test@123              |  
    Then User verify toast message "User with this email already exists"     
  	
  	Examples:
		|	Email			  | Password	| 
		|admin@localmoves.com | 1234		|
	

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
		|	Email			   | Password	|
		|Testing990@gmail.com  | Test@123	|		

	
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
		|Testing990@gmail.com | Test@1a23	|	

		
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
		|Testing90@gmail.com  |  1234567	|


Scenario Outline: Verify a customer successfully books a shipment from collection to delivery
    Given User launches application
    When User accepts cookies
    And User navigates to Customer Login
    And User enters email "<Email>"
    And User enters password "<Password>"
    And User clicks login
    Then User verify toast message "Login successful!"
    When User navigates to the Quick Quote page
    And User enters collection postcode "<CollectionPostcode>"
    And User enters delivery postcode "<DeliveryPostcode>"
    And User selects "<MoveType>" from dropdown 1
    And User selects "<PropertySize>" from dropdown 2
    And User selects "<Quantity>" from dropdown 3
    And User clicks on the Compare Prices button
    Then User clicks on the Final Quote button
    And User selects "GHAR" from the "Office" inventory
    When User enters the following address details
      | CollectionAddress | CollectionPostcode | DeliveryAddress | DeliveryPostcode |
      | 10 Main Street    | AB10 1AA           | 25 King Road    | AB21 5XY         |
    Then User selects "Driveway" from property assessment 1
    Then User selects "Stair Only" from property assessment 1
    Then User selects "Ground Floor" from property assessment 1
    Then User selects "Flat" from property assessment 1
    Then User selects "Driveway" from property assessment 2
    Then User selects "Stair Only" from property assessment 2
    Then User selects "Ground Floor" from property assessment 2
    Then User click on Next Step button
    Then User selects date 30 from the calendar
    And User clicks on Book Service button
    Then User clicks on Pay Deposit & Confirm Booking button
    Then User selects PayPal as the payment method
    And User logs in to PayPal using email "sb-favaj47519721@personal.example.com" and password "J%m{i!9?"
    And User confirms the PayPal payment
    Then User should be redirected to the Home page after successful payment
    Then User navigate to My Bookings page
  	Then the user should see the booking order with route "<CollectionPostcode>" to "<DeliveryPostcode>"

    Examples:
      | Email                | Password  | CollectionPostcode | DeliveryPostcode | MoveType    | PropertySize | Quantity |
      | Testing88@gmail.com | Test@123  | AB10               | AB12             | A Few Items | Small Van    | Half Van |


Scenario Outline: Verify that a user who has already placed an order with an email address cannot place another order for the same email
	Given User launches application
    When User accepts cookies
    And User navigates to Customer Login
    And User enters email "<Email>"
    And User enters password "<Password>"
    And User clicks login
    Then User verify toast message "Login successful!"
    When User navigates to the Quick Quote page
    And User enters collection postcode "<CollectionPostcode>"
    And User enters delivery postcode "<DeliveryPostcode>"
    And User selects "<MoveType>" from dropdown 1
    And User selects "<PropertySize>" from dropdown 2
    And User selects "<Quantity>" from dropdown 3
    And User clicks on the Compare Prices button
    Then the user should see the "No Companies Found" message
    
    Examples:
      | Email                | Password  | CollectionPostcode | DeliveryPostcode | MoveType    | PropertySize | Quantity |
      | Testing88@gmail.com | Test@123	| AB10               | AB12             | A Few Items | Small Van    | Half Van |


Scenario Outline: Verify successfully placed order is reflected in the Admin panel
  	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Click on the Quotes page
    Then User Validate Customer Quote ID is matching with the Admin Quote ID for "<Email>" and "<Password>"
  	
  	Examples:
		|	Email			  | Password	| Email					|	Password	|
		|admin@localmoves.com | 1234		| Testing88@gmail.com	|	Test@123	|