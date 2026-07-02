package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	WebDriver driver;
	WebDriverWait wait;
	HomePage homepage;
	LoginPage loginpage;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
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

	private By byCompanyName = By.xpath("//input[@placeholder='Enter company name']");

	private By byCompanyEmail = By.xpath("//input[@placeholder='you@company.com']");
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
		;
	}

	public void clickAddCompanyBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(byAddCompanyBtn)).click();
		;
	}

	public void fillStep1ForCompanyRegisteration(String companyName, String companyEmail, String companyPassword,
			String firstName, String lastName, String phone, String subscription) {

		driver.findElement(byCompanyName).sendKeys(companyName);
		driver.findElement(byCompanyEmail).sendKeys(companyEmail);
		driver.findElement(byPassword).sendKeys(companyPassword);
		driver.findElement(byFirstName).sendKeys(firstName);
		driver.findElement(byLastName).sendKeys(firstName);
		driver.findElement(byLastName).sendKeys(lastName);
		driver.findElement(byphone).sendKeys(phone);
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
}
