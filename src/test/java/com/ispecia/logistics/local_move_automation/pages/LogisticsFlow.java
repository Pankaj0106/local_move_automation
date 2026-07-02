package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

public class LogisticsFlow {

	WebDriver driver;
	WebDriverWait wait;
	private JavascriptExecutor js;

	public LogisticsFlow(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js = (JavascriptExecutor) driver;
	}

	private By QuickQuoteBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/aside[1]/div[1]/nav[1]/ul[1]/li[1]/span[1]");

	private By CollectionPostcodeField = By.xpath("//input[@placeholder='Enter Postcode (e.g. SW1A)']");

	private By DeliveryPostcodeField = By.xpath("//input[@placeholder='Enter Postcode (e.g. M1)']");

	private By FinalQuoteBtn = By.xpath("//button[.//span[normalize-space()='Final Quote']]");

	private By NextStepBtn = By.xpath("//button[contains(normalize-space(.),'Next Step')]");

	private By ByEnterCollectionAddress = By.xpath("//input[@placeholder='Enter collection address']");

	private By ByEnterCollectionPostcode = By.xpath("//input[@placeholder='Full postcode']");

	private By ByEnterDeliveryAddress = By.xpath("//input[@placeholder='Enter delivery address']");

	private By ByEnterDeliveryPostcode = By.xpath("(//input[@placeholder='Full postcode'])[2]");

	private By calendarLocator = By.xpath("//div[contains(@class,'overflow-y-auto')]");

	private By bySearchCompanyBtn = By.xpath("//button[normalize-space()='Search Companies']");

	private By byBookServiceBtn = By.xpath(
			"//button[contains(@class,'px-6 py-2.5 bg-pink-600 text-white font-semibold rounded-lg hover:bg-pink-700 transition-colors w-full max-w-[200px]')]");

	private By payDepositAndConfirmBookingButton = By
			.xpath("//button[normalize-space()='Pay Deposit & Confirm Booking']");

	private By ComparePricesButton = By.xpath("//*[@id='root']/div/section[1]/div[3]/div[1]/form/div[2]/button");

	private By BySelectCalendarDate(int date) {
		return By.xpath("(//button[not(@disabled) and ./div[1]/span[normalize-space()='" + date + "']])[2]");
	}

	private By BySelectDetailsPropertyAssesement(String property, int index) {
		return By.xpath("(//button[.//span[normalize-space()='" + property + "']])[" + index + "]");
	}

	public void selectDetailsPropertyAssesement(String property, int index) {
		driver.findElement(BySelectDetailsPropertyAssesement(property, index)).click();
	}

	private By RoomItems(String items) {
		return By.xpath("//summary[.//span[normalize-space()='" + items + "']]");
	}

	public By increaseButton(String itemName) {
		return By.xpath("//h3[normalize-space()='" + itemName
				+ "']/ancestor::div[contains(@class,'justify-between')][1]//button[contains(@aria-label,'Increase')]");
	}

	private By serviceTypeDropdown(int num) {
		return By
				.xpath("(//*[normalize-space()='Move Type']/following::button[@aria-haspopup='listbox'])[" + num + "]");
	}

	private By ByNoCompaniesMsg = By.xpath("//h3[@class='text-xl font-semibold text-gray-700 mb-2']");

	private By ByClickMyBookings = By.xpath("//span[normalize-space()='My Bookings']");

	By pincodeValidateInBookingPage = By.xpath("//p[contains(.,'Pincodes')]");

	public void waitThread() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectItemsFromDropdowns(String moveType, int num) {

		waitThread();
		driver.findElement(serviceTypeDropdown(num)).click();
		By optionLocator = By
				.xpath("//ul[@role='listbox']//li[@role='option'][.//span[normalize-space()='" + moveType + "']]");

		driver.findElement(optionLocator).click();
	}

	public void QuickQuoteClicks() {
		wait.until(ExpectedConditions.elementToBeClickable(QuickQuoteBtn)).click();
	}

	public void CollectionPostcode(String collectionPostcode) {
		waitThread();
		driver.findElement(CollectionPostcodeField).sendKeys(collectionPostcode);
		;
	}

	public void DeliveryPostcode(String deliveryPostcode) {
		waitThread();
		driver.findElement(DeliveryPostcodeField).sendKeys(deliveryPostcode);
		;
	}

	public void ComparePricesClick() {
		wait.until(ExpectedConditions.elementToBeClickable(ComparePricesButton)).click();
	}

	public void FinalQuoteClicks() {
		wait.until(ExpectedConditions.elementToBeClickable(FinalQuoteBtn)).click();
	}

	public static void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void SelectItemsFromInventory(String itemName, String roomName) {
		wait.until(ExpectedConditions.elementToBeClickable(RoomItems(roomName))).click();

		wait.until(ExpectedConditions.elementToBeClickable(increaseButton(itemName))).click();

		scrollToBottom();

	}

	public void NextStepClick() {
		driver.findElement(NextStepBtn).click();
	}

	public void enterCollectionAddress(String collectionAddress) {

		driver.findElement(NextStepBtn).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ByEnterCollectionAddress));
		driver.findElement(ByEnterCollectionAddress).sendKeys(collectionAddress);
	}

	public void enterCollectionPostcode(String collectionPostcode) {
		driver.findElement(ByEnterCollectionPostcode).sendKeys(collectionPostcode);
	}

	public void enterDeliveryAddress(String deliveryAddress) {
		driver.findElement(ByEnterDeliveryAddress).sendKeys(deliveryAddress);
	}

	public void enterDeliveryPostcode(String deliveryPostcode) {
		driver.findElement(ByEnterDeliveryPostcode).sendKeys(deliveryPostcode);
		driver.findElement(NextStepBtn).click();
	}

	public void selectCalendarDate(int date) {

		WebElement calendar = driver.findElement(calendarLocator);
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", calendar);
		waitThread();
		wait.until(ExpectedConditions.elementToBeClickable(BySelectCalendarDate(date))).click();
		wait.until(ExpectedConditions.elementToBeClickable(bySearchCompanyBtn)).click();
	}

	public void BookServiceBtnClick() {
		while (driver.findElements(byBookServiceBtn).isEmpty()) {
			js.executeScript("window.scrollBy(0, 500);");
		}

		WebElement bookServiceBtn = driver.findElement(byBookServiceBtn);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", bookServiceBtn);
		bookServiceBtn.click();
	}

	public void clickPayDepositAndConfirmBookingButton() {

		while (driver.findElements(payDepositAndConfirmBookingButton).isEmpty()) {
			js.executeScript("window.scrollBy(0, 500);");
		}

		WebElement depositConfirmBtn = driver.findElement(payDepositAndConfirmBookingButton);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", depositConfirmBtn);
		depositConfirmBtn.click();
	}

	public String getNoCompaniesFoundMessage() {
		// return driver.findElement(ByNoCompaniesMsg).getText();
		return wait.until(ExpectedConditions.presenceOfElementLocated(ByNoCompaniesMsg)).getText();
	}

	public void clickMyBookings() {
		wait.until(ExpectedConditions.elementToBeClickable(ByClickMyBookings)).click();
	}

	public void verifyBookingOrder(String collectionPostcode, String deliveryPostcode) {

		String pincodeText = wait.until(ExpectedConditions.presenceOfElementLocated(pincodeValidateInBookingPage))
				.getText();
		String expectedMessage = collectionPostcode + " → " + deliveryPostcode;
		Assert.assertEquals(pincodeText.split(":")[1].trim(), expectedMessage);
	}
}
