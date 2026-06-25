package com.ispecia.logistics.local_move_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-features=PasswordLeakDetection");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://local-moves-frontend-phi.vercel.app/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		
		
		driver.findElement(By.xpath("//button[@type='button'][.//*[contains(@class,'lucide-menu')]]")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement customerLogin = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[@href='/login?type=customer']")
		    )
		);

		customerLogin.click();
		
		
		//Login to Customer portal using credentials
		driver.findElement(By.xpath("//input[@placeholder='admin@localmoves.com']")).sendKeys("newtest123@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(5000);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Toastify__toast')][1]")));
		
		String actualMessage = alertElement.getText();
		
		System.out.println(actualMessage);
		String expectedMessage = "Login successful!";
		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
		driver.findElement(By.xpath("//button[@type='button'][.//*[contains(@class,'lucide-menu')]]")).click();
		
		
		//Thread.sleep(10000);
		
		WebElement customerLogout = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("(//button[contains(normalize-space(.),'Logout')])[2]")
			    )
			);
		
		customerLogout.click();
		
		//Thread.sleep(2000);
		
		String actualMessage1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'Toastify__toast')]"))).getText();
		
		String expectedMessage1 = "You've been logged out successfully!";
		
		Assert.assertEquals(actualMessage1, expectedMessage1);
		
		driver.quit();
		
	}

}
