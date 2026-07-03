package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	WebDriver driver;
	WebDriverWait wait;
	HomePage homepage;
	LoginPage loginpage;
	JavascriptExecutor js;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		this.js = (JavascriptExecutor) driver;
	}

	private By byClickQuoteBtn = By.xpath("//a[normalize-space()='Quotes']");

	private By byQuoteIdCustomer = By.xpath("(//span[starts-with(normalize-space(), 'REQ-')])[1]");

	private By byQuoteIdAdmin = By.xpath("(//span[starts-with(normalize-space(), 'REQ-')])[2]");

	private By byCustomersBtn = By.xpath("//a[normalize-space()='Customers']");

	private By byAddNewCustomerBtn = By.xpath("//button[normalize-space()='Add New Customer']");

	private By txtFullName = By.xpath("//input[@placeholder='Enter full name']");

	private By txtEmail = By.xpath("//input[@placeholder='user@example.com']");

	private By txtPhone = By.xpath("//input[@placeholder='Phone number']");

	private By txtPassword = By.xpath("//input[@placeholder='Min. 8 characters']");

	private By btnCreateCustomer = By.xpath("//button[normalize-space()='Create Customer']");

	private By byCalcelBtn = By.xpath("//button[normalize-space() = 'Cancel']");

	private By byCustomerBtn = By.xpath("//a[normalize-space()='Companies']");

	private By byAddCompanyBtn = By.xpath("//button[normalize-space()='Add Company']");

	private By byCompanyName = By.xpath("//input[@name='company_name']");

	private By byCompanyEmail = By.xpath("//input[@name='manager_email']");

	private By byPassword = By.xpath("//input[@name='password']");

	private By byFirstName = By.xpath("//input[@name='firstName']");

	private By byLastName = By.xpath("//input[@name='lastName']");

	private By byphone = By.xpath("//input[@name='phone']");

	private By bySubscription = By.xpath("//select[@name='subscription_plan']");

	private By byNextStepBtn = By.xpath("//button[normalize-space()='Next Step']");

	private By byPostcode = By.xpath("//input[@name='pincode']");

	private By byCity = By.xpath("//input[@name='location']");

	private By byAddress = By.xpath("//textarea[@name='address']");

	private By byCoverAllAreasBtn = By.xpath("//button[normalize-space()='Cover All Areas']");

	private By byRegisterCompanyBtn = By.xpath("//button[normalize-space()='Register Company']");

	private By bySaveChangesButton = By.xpath("//button[normalize-space()='Save Changes']");
	
	public void refreshThePage() {
		driver.findElement(By.tagName("body")).sendKeys(Keys.F5);
	}

	public void clickEditByCompanyName(String companyName) {
		By editButton = By
				.xpath("//tr[.//span[normalize-space()='" + companyName + "']]//button[normalize-space()='Edit']");

		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
	}

	public void fillStep2ForCompanyRegisteration(String postcode, String city, String address) {

		driver.findElement(byPostcode).sendKeys(postcode);
		driver.findElement(byCity).sendKeys(city);
		driver.findElement(byAddress).sendKeys(address);
		driver.findElement(byCoverAllAreasBtn).click();
	}

	public void clickRegisterCompanyButton() {
		wait.until(ExpectedConditions.elementToBeClickable(byRegisterCompanyBtn)).click();
	}

	public void clickQuote() {
		wait.until(ExpectedConditions.elementToBeClickable(byClickQuoteBtn)).click();
	}

	public String fetchQuoteIDAdmin() {
		return (wait.until(ExpectedConditions.presenceOfElementLocated(byQuoteIdAdmin)).getText());
	}

	public String fetchQuoteIDCustomer(String email, String pass) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage.clickHamburgerMenu();
		homepage.clickLogout();
		loginpage.enterEmail(email);
		loginpage.enterPassword(pass);
		loginpage.clickLogin();
		return (wait.until(ExpectedConditions.presenceOfElementLocated(byQuoteIdCustomer)).getText());
	}

	public void CustomerBtnClick() {
		driver.findElement(byCustomersBtn).click();
	}

	public void ClickAddNewCustomerBtn() {
		driver.findElement(byAddNewCustomerBtn).click();
	}

	public void enterFullName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtFullName)).sendKeys(name);
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail)).sendKeys(email);
	}

	public void enterPhone(String phone) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPhone)).sendKeys(phone);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).sendKeys(password);
	}

	public void clickCreateCustomer() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCreateCustomer)).click();
	}

	public boolean isCustomerPresent(String email) {
		By byCustomerPresent = By.xpath("//td[normalize-space() = '" + email + "']");
		return !driver.findElements(byCustomerPresent).isEmpty();
	}

	public void clickCancelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(byCalcelBtn)).click();
	}

	public void clickCustomersBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(byCustomerBtn)).click();
	}

	public void clickAddCompanyBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(byAddCompanyBtn)).click();

	}

	public void fillStep1ForCompanyRegisteration(String companyName, String companyEmail, String companyPassword,
			String firstName, String lastName, String phone, String subscription) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(byCompanyName)).sendKeys(companyName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCompanyEmail)).sendKeys(companyEmail);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(companyPassword);

		wait.until(ExpectedConditions.visibilityOfElementLocated(byFirstName)).sendKeys(firstName);

		wait.until(ExpectedConditions.visibilityOfElementLocated(byLastName)).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byphone)).sendKeys(phone);

		WebElement sub_plan = driver.findElement(bySubscription);
		Select select = new Select(sub_plan);
		select.selectByVisibleText(subscription);
	}

	public void clickNextButton() {
		wait.until(ExpectedConditions.elementToBeClickable(byNextStepBtn)).click();
	}

	public boolean isCompanyPresent(String companyName) {
		By locator = By.xpath("//span[normalize-space()='" + companyName + "']");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void updateCompanyDetail(String companyName) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(byCompanyName)).clear();
		;
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCompanyName)).sendKeys(companyName);
	}

	public void clickSaveChangesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(bySaveChangesButton)).click();
	}

	public void clickDeleteIcon(String companyName) {
		By deleteButton = By
				.xpath("//tr[.//span[normalize-space()='" + companyName + "']]//button[normalize-space()='Delete']");

		wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
	}

	public void clickPromptConfirmCancel(String confirmDeleteSelection) {
		By byconfirmButton = By.xpath("//h2[normalize-space()='Delete Company?']/following::button[normalize-space()='"
				+ confirmDeleteSelection + "'][1]");

		wait.until(ExpectedConditions.elementToBeClickable(byconfirmButton)).click();
	}

	public boolean verifyCompanyPresence(String companyName) {

		By deletedAccountPresenceCheck = By.xpath("//tr[.//span[contains(normalize-space(),'" + companyName
				+ "_DELETED_')] and .//span[normalize-space()='Deleted by admin']]");
		return !driver.findElements(deletedAccountPresenceCheck).isEmpty();
	}
	
	public boolean verifyCustomerPresence(String customerID) {

		By deletedAccountPresenceCheck = By.xpath("//tr[.//td[contains(normalize-space(),'" + customerID
				+ "_DELETED_')] and .//span[normalize-space()='Deleted by admin']]");
		return !driver.findElements(deletedAccountPresenceCheck).isEmpty();
	}

	public void clickEditButton(String customerEmail) {

		By ByEditButton = By
				.xpath("//tr[.//td[normalize-space()='" + customerEmail + "']]//button[normalize-space()='Edit']");
		wait.until(ExpectedConditions.elementToBeClickable(ByEditButton)).click();
	}

	public void updateCustomerDetails(String fullName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtFullName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtFullName)).sendKeys(fullName);
		;
	}

	public void deleteCustomerByEmail(String email) {

		By deleteButton = By.xpath("//tr[.//td[normalize-space()='" + email + "']]//button[contains(.,'Delete')]");

		wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
	}
	
	public void clickConfirmButton(String confirmButton) {
		By deleteButton = By.xpath("//div[h2[normalize-space()='Delete Customer']]//button[normalize-space()='"+confirmButton+"']");
	    wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
	}
}
