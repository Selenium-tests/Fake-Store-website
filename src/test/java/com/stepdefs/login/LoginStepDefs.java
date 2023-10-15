package com.stepdefs.login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.account.Account;
import qa.pages.LoginForm;
import qa.pages.MainMenu;

import static qa.driver.Driver.*;

public class LoginStepDefs {

    private LoginForm loginForm;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
    }

    @Given("The user goes to the login page")
    public void theUserGoesToTheLoginPage() {

        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenu.click("Moje konto");

        loginForm = new LoginForm(getDriver());
    }

    @When("The user types a correct email address {string}")
    @When("The user types an incorrect username {string}")
    @When("The user types an incorrect email address {string}")
    public void theUserTypesAnIncorrectUsername(String data) {

        loginForm.setUsername(data);
    }

    @And("Types a correct password {string}")
    @And("Types an incorrect password {string}")
    public void andTypesACorrectPassword(String password) {

        loginForm.setPassword(password);
    }

    @And("The user leaves the username or password field blank")
    public void leavesTheUsernameOrEmailAddressField() {

        loginForm.setUsername("");
    }


    @And("Leaves the password field blank")
    public void leavesThePasswordField() {

        loginForm.setPassword("");
    }

    @And("Clicks the submit button")
    public void andClicksTheSubmitButton() {

        loginForm.clickSubmitButton();
    }

    @Then("The incorrect username message has been displayed")
    @Then("The incorrect email address message has been displayed")
    @Then("The blank username or email address field message has been displayed")
    @Then("The incorrect password message has been displayed")
    @Then("The blank password field has been displayed")
    public void theIncorrectUsernameMessageHasBeenDisplayed() {

        Assert.assertTrue(loginForm.isErrorMessageDisplayed());
    }

    @And("The error message text is {string}")
    public void theErrorMessageTextIs(String errorMessage) {

        Assert.assertEquals(loginForm.getErrorMessageText(), errorMessage);
    }

    @Then("The user is logged in")
    public void theUserIsLoggedIn() {

        Account account = new Account(getDriver());

        Assert.assertTrue(account.areNavigationButtonsVisible());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
