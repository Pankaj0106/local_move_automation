package com.ispecia.logistics.local_move_automation.stepdefinitions;

import org.testng.Assert;

import com.ispecia.logistics.local_move_automation.pages.HomePage;
import com.ispecia.logistics.local_move_automation.pages.LoginPage;
import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    HomePage homePage =
            new HomePage(DriverFactory.getDriver());

    LoginPage loginPage =
            new LoginPage(DriverFactory.getDriver());

    @Given("User launches application")
    public void launchApplication() {

        DriverFactory.getDriver()
                .get("https://local-moves-frontend-phi.vercel.app/");
    }

    @When("User accepts cookies")
    public void acceptCookies() {

        homePage.acceptCookies();
    }

    @When("User navigates to Customer Login")
    public void navigateToCustomerLogin() {

        homePage.clickHamburgerMenu();
        homePage.clickCustomerLogin();
    }

    @When("User enters email {string}")
    public void enterEmail(String email) {

        loginPage.enterEmail(email);
    }

    @When("User enters password {string}")
    public void enterPassword(String password) {

        loginPage.enterPassword(password);
    }

    @When("User clicks login")
    public void clickLogin() {

        loginPage.clickLogin();
    }

    @Then("Verify login success message {string}")
    public void verifyLoginSuccess() {

        Assert.assertTrue(
                loginPage.getToastMessage()
                        .contains("Login successful!")
        );       
    }
    
    @Then("User verify toast message {string}")
    public void userVerifyToastMessage(String expectedToastMessage) {
        Assert.assertEquals(loginPage.getToastMessage(), expectedToastMessage);
        loginPage.waitToastMessageDisappear();
    }

    @When("User clicks logout")
    public void clickLogout() throws InterruptedException {
    	Thread.sleep(3000);
        homePage.clickHamburgerMenu();
        homePage.clickLogout();
    }

    @Then("Verify logout success message")
    public void verifyLogoutSuccess() {

        Assert.assertTrue(
                loginPage.getToastMessage()
                        .contains("logged out successfully")
        );
    }
}