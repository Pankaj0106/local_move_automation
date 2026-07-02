package com.ispecia.logistics.local_move_automation.stepdefinitions;

import java.util.Map;

import org.testng.Assert;

import com.ispecia.logistics.local_move_automation.pages.LogisticsFlow;
import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogisticsFlowStep {

	LogisticsFlow logisticsFlow = new LogisticsFlow(DriverFactory.getDriver());

	@When("User navigates to the Quick Quote page")
	public void user_navigates_to_the_quick_quote_page() {

		logisticsFlow.QuickQuoteClicks();

	}

	@And("User enters collection postcode {string}")
	public void user_enters_collection_postcode(String collectionPostcode) {

		logisticsFlow.CollectionPostcode(collectionPostcode);

	}

	@And("User enters delivery postcode {string}")
	public void user_enters_delivery_postcode(String deliveryPostcode) {

		logisticsFlow.DeliveryPostcode(deliveryPostcode);

	}

	@And("User selects {string} from dropdown {int}")
	public void user_selects_from_dropdown(String option, Integer dropdownNumber) {

		logisticsFlow.selectItemsFromDropdowns(option, dropdownNumber);

	}

	@And("User clicks on the Compare Prices button")
	public void user_clicks_on_the_compare_prices_button() {

		logisticsFlow.ComparePricesClick();

	}

	@Then("User clicks on the Final Quote button")
	public void user_clicks_on_the_final_quote_button() {
		logisticsFlow.FinalQuoteClicks();
	}

	@And("User selects {string} from the {string} inventory")
	public void userSelectsItemFromInventory(String itemName, String roomName) {
		logisticsFlow.SelectItemsFromInventory(itemName, roomName);
	}

	@When("User enters the following address details")
	public void userEntersTheFollowingAddressDetails(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps().get(0);

		logisticsFlow.enterCollectionAddress(data.get("CollectionAddress"));
		logisticsFlow.enterCollectionPostcode(data.get("CollectionPostcode"));

		logisticsFlow.enterDeliveryAddress(data.get("DeliveryAddress"));
		logisticsFlow.enterDeliveryPostcode(data.get("DeliveryPostcode"));
	}

	@Then("User selects {string} from property assessment {int}")
	public void userSelectsFromPropertyAssessment(String property, int index) {
		logisticsFlow.selectDetailsPropertyAssesement(property, index);
	}

	@Then("User click on Next Step button")
	public void user_click_on_next_step_button() {
		logisticsFlow.NextStepClick();
	}

	@Then("User selects date {int} from the calendar")
	public void userSelectsDateFromTheCalendar(int date) {

		logisticsFlow.selectCalendarDate(date);
	}

	@And("User clicks on Book Service button")
	public void userClicksOnBookServiceButton() {
		logisticsFlow.BookServiceBtnClick();
	}

	@Then("User clicks on Pay Deposit & Confirm Booking button")
	public void userClicksOnPayDepositAndConfirmBookingButton() {
		logisticsFlow.clickPayDepositAndConfirmBookingButton();
	}
	
	@Then("the user should see the {string} message")
	public void theUserShouldSeeTheMessage(String expectedMessage) {
	    Assert.assertEquals(logisticsFlow.getNoCompaniesFoundMessage(), expectedMessage);
	}
	
	@Then("User navigate to My Bookings page")
	public void userNavigateToMyBookingsPage() {
		logisticsFlow.clickMyBookings();
	}
	
	@Then("the user should see the booking order with route {string} to {string}")
	public void the_user_should_see_the_booking_order_with_route_to(String collectionPostcode, String deliveryPostcode) {
		logisticsFlow.verifyBookingOrder(collectionPostcode,deliveryPostcode);
	}

}
