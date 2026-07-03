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
		

Scenario Outline: Verify user is able to successfully Add New Company
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
	Then User navigate to Companies section
	And User clicks on Add Company Button
	Then Fill details for Step1
		|CompanyName 	|	A3	 		|
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

	
Scenario Outline: Verify user is able to successfully Edit New Company
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
	Then User navigate to Companies section
	And User clicks on Add Company Button
	Then Fill details for Step1
		|CompanyName 	|	D01	 		|
		|CompanyEmail	| d01@gmail.com	|
		|Password		|	123456	 	|
		|FirstName		|	Test	 	|
		|LastName		|	123		 	|
		|Phone			| 9710138500 	|
		|Subscription 	|Jobs - Founder	|
	Then User clicks on the Next Step
	Then User Fill details foe Step2
		|Postcode	|  Ab100	|
		|City		|  Testing	|
		|Address	|  Test		|
	And User clicks on Register Company button
	Then the company "D01" should be visible in the company list
	Then User clicks on the Edit button for the "D01"
	Then User partially update the data
		|CompanyName	|	D60	|
  	Then User clicks on the Next Step	
  	And User clicks on Save Changes button	
  	Then the company "D60" should be visible in the company list
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|
	
	
Scenario Outline: Verify user is able to successfully Delete Added Company
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
	Then User navigate to Companies section
	And User clicks on Add Company Button
	Then Fill details for Step1
		|CompanyName 	|	D04	 		|
		|CompanyEmail	| d04@gmail.com	|
		|Password		|	123456	 	|
		|FirstName		|	Test	 	|
		|LastName		|	123		 	|
		|Phone			| 9720433500 	|
		|Subscription 	|Jobs - Founder	|
	Then User clicks on the Next Step
	Then User Fill details for Step2
		|Postcode	|  Ab100	|
		|City		|  Testing	|
		|Address	|  Test		|
	And User clicks on Register Company button
	Then the company "D04" should be visible in the company list
	Then User clicks on Delete Icon for "D04"
	Then Click on "Delete" button
	Then User verify company "D01" presence is "false"
  	
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

	
Scenario Outline: Verify user is able to successfully Edit Customer details
	Given User launches application
  	When User accepts cookies
  	And User navigates to Customer Login
  	And User enters email "<Email>"
  	And User enters password "<Password>"
  	And User clicks login
    Then User verify toast message "Login successful!"
    And User Navigates to Customers section
    When User creates a new customer with following details
      | FullName | Pb		           |
      | Email    | pb02@gmail.com      |
      | Country  | GB +44              |
      | Phone    | 75363450045         |
      | Password | Test@123            |  
    And the user clicks the Create Customer button
    Then User verify toast message "User created successfully"
    Then the customer "pb02@gmail.com" should be present in the customer grid as "true"
    Then User clicks on Edit button for customer "pb02@gmail.com"
    Then User updates the customer details
  	  | FullName | Pankaj |
  	And User clicks on Save Changes button	
  	Then the customer "Pankaj" should be present in the customer grid as "true"
  	
  	Examples:
	|	Email			  | Password	| 
	|admin@localmoves.com | 1234		|	
	

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
	


	
	
