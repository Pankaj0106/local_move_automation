 package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PaymentPage {

	WebDriver driver;
	WebDriverWait wait;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private String parentWindow;

	private By paypalFrame = By.xpath("//iframe[contains(@title,'PayPal')]");

	private By paypalButton = By.xpath("//div[@data-funding-source='paypal']");

	private By loginButton = By.xpath("//a[contains(text(),'Log In')] | //button[contains(text(),'Log In')]");

	private By email = By.id("email");

	private By nextButton = By.id("btnNext");

	private By password = By.id("password");

	private By loginSubmit = By.id("btnLogin");

	private By paymentSubmit = By.xpath("//button[@data-id='payment-submit-btn']");

	private By paymentSuccessMessage = By.xpath("//h3[normalize-space()='Payment Successful! 🎉']");

	private By homePage = By.xpath("//button[normalize-space()='View Booking Details']");

	public void selectPaypal() {

		parentWindow = driver.getWindowHandle();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paypalFrame));

		wait.until(ExpectedConditions.elementToBeClickable(paypalButton)).click();

		wait.until(ExpectedConditions.elementToBeClickable(paypalButton)).click();

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {

			if (!window.equals(parentWindow)) {

				driver.switchTo().window(window);

				break;
			}
		}
	}

	public void loginToPaypal(String userEmail, String userPassword) {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		} catch (Exception e) {

			System.out.println("Already on login page");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(email));

		driver.findElement(email).clear();

		driver.findElement(email).sendKeys(userEmail);

		driver.findElement(nextButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(password));

		driver.findElement(password).sendKeys(userPassword);

		driver.findElement(loginSubmit).click();
	}

	public void confirmPayment() {

		wait.until(ExpectedConditions.elementToBeClickable(paymentSubmit)).click();

		driver.switchTo().window(parentWindow);
	}

	public void verifyPaymentSuccessAndNavigateHome() {

		String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentSuccessMessage))
				.getText();

		Assert.assertEquals(actualMessage, "Payment Successful! 🎉");

		wait.until(ExpectedConditions.elementToBeClickable(homePage)).click();
	}

}
