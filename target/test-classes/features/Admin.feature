Feature: Admin feature validation

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
      | Email               | Password  | CollectionPostcode | DeliveryPostcode | MoveType    | PropertySize | Quantity |
      | Testing15@gmail.com | Testing15 | AB10               | AB12             | A Few Items | Small Van    | Half Van |



Scenario Outline: Verify successfully placed order is reflected in the Admin panel
  	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Click on the Quotes page
    Then User Validate Customer Quote ID is matching with the Admin Quote ID
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|
	

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
      | Email    | pb00@gmail.com   	 |
      | Country  | GB +44                |
      | Phone    | 0030043300            |
      | Password | Test@123              |  
    And the user clicks the Create Customer button
    Then User verify toast message "User created successfully"
   Then the customer "pb00@gmail.com" should be present in the customer grid as "true"
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|

	
Scenario Outline: Cancel customer creation should not create a customer
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
      | Email    | pb01@gmail.com   	 |
      | Country  | GB +44                |
      | Phone    | 0030043321            |
      | Password | Test@123              |  
    And the user clicks the Cancel button
    Then the customer "pb01@gmail.com" should be present in the customer grid as "false"
  	
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
      | Email    | johnsmith@gmail.com   |
      | Country  | GB +44                |
      | Phone    | 9876543210            |
      | Password | Test@123              |  
    Then User verify toast message "User with this email already exists"     
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|
	
	
