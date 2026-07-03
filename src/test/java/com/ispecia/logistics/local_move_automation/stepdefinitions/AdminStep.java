package com.ispecia.logistics.local_move_automation.stepdefinitions;

import java.util.Map;

import org.testng.Assert;

import com.ispecia.logistics.local_move_automation.pages.AdminPage;
import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminStep {

	AdminPage adminPage = new AdminPage(DriverFactory.getDriver());
	
	@And("Refresh the page")
	public void refresh_the_page() {
	    adminPage.refreshThePage();
	}

	@Then("User Click on the Quotes page")
	public void user_click_on_the_quotes_page() {
		adminPage.clickQuote();
	}

	@Then("User Validate Customer Quote ID is matching with the Admin Quote ID for {string} and {string}")
	public void user_validate_customer_quote_id_is_matching_with_the_admin_quote_id_for_and(String email,
			String password) {
		Assert.assertEquals(adminPage.fetchQuoteIDAdmin(), adminPage.fetchQuoteIDCustomer(email, password));
	}

	@Then("User Navigates to Customers section")
	public void user_navigates_to_customers_section() {
		adminPage.CustomerBtnClick();
	}

	@And("the user clicks the Create Customer button")
	public void theUserClicksTheCreateCustomerButton() {
		adminPage.clickCreateCustomer();
	}

	@When("User creates a new customer with following details")
	public void user_creates_a_new_customer_with_following_details(DataTable dataTable) {

		Map<String, String> customer = dataTable.asMap(String.class, String.class);
		adminPage.ClickAddNewCustomerBtn();
		adminPage.enterFullName(customer.get("FullName"));
		adminPage.enterEmail(customer.get("Email"));
		adminPage.enterPhone(customer.get("Phone"));
		adminPage.enterPassword(customer.get("Password"));
	}

	@Then("the customer {string} should be present in the customer grid as {string}")
	public void the_customer_should_be_present_in_the_customer_grid_as(String email, String isPresent) {

		boolean expectedResult = Boolean.parseBoolean(isPresent);
		boolean actualResult = adminPage.isCustomerPresent(email);
		Assert.assertEquals(expectedResult, actualResult);
	}

	@And("the user clicks the Cancel button")
	public void theUserClicksTheCancelButton() {
		adminPage.clickCancelButton();
	}

	@Then("User navigate to Companies section")
	public void user_navigate_to_companies_section() {

		adminPage.clickCustomersBtn();
	}

	@Then("User clicks on Add Company Button")
	public void user_clicks_on_add_company_button() {

		adminPage.clickAddCompanyBtn();
	}

	@Then("Fill details for Step1")
	public void fill_details_for_step1(DataTable dataTable) {

		Map<String, String> company_details = dataTable.asMap(String.class, String.class);
		String companyName = company_details.get("CompanyName");
		String companyEmail = company_details.get("CompanyEmail");
		String companyPassword = company_details.get("Password");
		String firstName = company_details.get("FirstName");
		String lastName = company_details.get("LastName");
		String phone = company_details.get("Phone");
		String subscription = company_details.get("Subscription");
		adminPage.fillStep1ForCompanyRegisteration(companyName, companyEmail, companyPassword, firstName, lastName,
				phone, subscription);
	}

	@Then("User clicks on the Next Step")
	public void user_clicks_on_the_next_step() {
		adminPage.clickNextButton();
	}

	@Then("User Fill details for Step2")
	public void user_fill_details_for_step2(DataTable dataTable) {

		Map<String, String> company_details_2 = dataTable.asMap(String.class, String.class);
		String postcode = company_details_2.get("Postcode");
		String city = company_details_2.get("City");
		String address = company_details_2.get("Address");

		adminPage.fillStep2ForCompanyRegisteration(postcode, city, address);
	}

	@Then("User clicks on Register Company button")
	public void user_clicks_on_register_company_button() {
		adminPage.clickRegisterCompanyButton();
	}

	@Then("the company {string} should be visible in the company list")
	public void the_company_should_be_visible_in_the_company_list(String companyName) {
		
		Assert.assertTrue(adminPage.isCompanyPresent(companyName));
	}
	
	@Then("User clicks on the Edit button for the {string}")
	public void user_clicks_on_the_edit_button_for_the(String companyName) {
	   adminPage.clickEditByCompanyName(companyName);
	}
	
	@Then("User partially update the data")
	public void user_partially_update_the_data(DataTable dataTable) {
	    
		Map<String,String> company_details = dataTable.asMap(String.class,String.class);
		String companyName = company_details.get("CompanyName");
		
		adminPage.updateCompanyDetail(companyName);		
	}
	
	@And("User clicks on Save Changes button")
	public void user_clicks_on_save_changes_button() {
		adminPage.clickSaveChangesButton();
	}
	
	@Then("User clicks on Delete Icon for {string}")
	public void user_clicks_on_delete_icon_for(String companyName) {
	    adminPage.clickDeleteIcon(companyName);
	}
	
	@Then("Click on {string} button")
	public void click_on_button(String confirmationBtn) {
		adminPage.clickPromptConfirmCancel(confirmationBtn);
	}
	
	@Then("User verify company {string} presence is {string}")
	public void user_verify_company_presence_is(String companyName, String expectedStatus) {
	    
		Boolean actualResult = adminPage.verifyCompanyPresence(companyName);
		Boolean expectedResult = Boolean.parseBoolean(expectedStatus);
	    Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Then("User verify customer {string} presence is {string}")
	public void user_verify_customer_presence_is(String customerID, String expectedStatus) {
	    
		Boolean actualResult = adminPage.verifyCustomerPresence(customerID);
		Boolean expectedResult = Boolean.parseBoolean(expectedStatus);
	    Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Then("User clicks on Edit button for customer {string}")
	public void user_clicks_on_edit_button_for_customer(String customerEmail) {
		 adminPage.clickEditButton(customerEmail);
	}
	
	@Then("User updates the customer details")
	public void user_updates_the_customer_details(DataTable dataTable) {
		
		Map<String, String> customer_details = dataTable.asMap(String.class, String.class);
		String fullName = customer_details.get("FullName");
	    adminPage.updateCustomerDetails(fullName);
	}

	@When("the user clicks the Delete button for the customer with email {string}")
	public void the_user_clicks_the_delete_button_for_the_customer_with_email(String email) {
		 adminPage.deleteCustomerByEmail(email);
	}
	
	@And("the user clicks the {string} button")
	public void the_user_clicks_the_button(String buttonName) {
	    adminPage.clickConfirmButton(buttonName);
	}
}