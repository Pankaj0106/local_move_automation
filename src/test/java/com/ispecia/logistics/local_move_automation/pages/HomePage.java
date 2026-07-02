package com.ispecia.logistics.local_move_automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By acceptCookie = By.xpath("//button[text()='Accept All']");

	By hamburgerMenu = By.xpath("//button[@type='button'][.//*[contains(@class,'lucide-menu')]]");

	By customerLogin = By.xpath("//a[@href='/login?type=customer']");

	By logoutButtons = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[4]/nav[1]/div[2]/button[1]");

	public void acceptCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookie)).click();
	}

	public void clickHamburgerMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
	}

	public void clickCustomerLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(customerLogin)).click();
	}

	public void clickLogout() {

		wait.until(ExpectedConditions.elementToBeClickable(logoutButtons)).click();
	}
}