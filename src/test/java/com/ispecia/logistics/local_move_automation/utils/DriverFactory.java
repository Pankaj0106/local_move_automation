package com.ispecia.logistics.local_move_automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static void initializeDriver() {

		driver = new EdgeDriver();

		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {

		return driver;
	}

	public static void quitDriver() {

		if (driver != null) {
			driver.quit();
		}
	}
}