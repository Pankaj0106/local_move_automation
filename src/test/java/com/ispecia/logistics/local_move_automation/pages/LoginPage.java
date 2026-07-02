package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By email = By.xpath("//input[@placeholder='admin@localmoves.com']");

	By password = By.xpath("//input[@type='password']");

	By loginButton = By.xpath("//button[@type='submit']");

	By toastMessage = By.xpath("//div[@role='alert']");

	public void enterEmail(String emailId) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emailId);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public String getToastMessage() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)).getAttribute("textContent")
				.trim();
	}

	public void waitToastMessageDisappear() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMessage));
	}

}