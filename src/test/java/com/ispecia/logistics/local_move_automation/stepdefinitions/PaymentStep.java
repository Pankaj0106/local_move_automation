package com.ispecia.logistics.local_move_automation.stepdefinitions;

import com.ispecia.logistics.local_move_automation.pages.PaymentPage;
import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PaymentStep {

	PaymentPage paymentPage = new PaymentPage(DriverFactory.getDriver());

	@Then("User selects PayPal as the payment method")
	public void userSelectsPayPalAsThePaymentMethod() {
		paymentPage.selectPaypal();
	}

	@And("User logs in to PayPal using email {string} and password {string}")
	public void userLogsIntoPaypal(String email, String password) {
		paymentPage.loginToPaypal(email, password);
	}

	@And("User confirms the PayPal payment")
	public void userConfirmsThePaypalPayment() {
		paymentPage.confirmPayment();
	}

	@Then("User should be redirected to the Home page after successful payment")
	public void userShouldBeRedirectedToTheHomePageAfterSuccessfulPayment() {
		paymentPage.verifyPaymentSuccessAndNavigateHome();
	}

}
