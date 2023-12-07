package com.stepdefs.login;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.account.Account;
import qa.pages.loginform.LoginForm;
import qa.pages.mainmenu.MainMenu;


public class LoginStepDefs {

    private final TestUtil testUtil;
    private final LoginForm loginForm;

    public LoginStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        loginForm = new LoginForm(testUtil.getDriver());
    }

    @Given("The user goes to the login page")
    public void theUserGoesToTheLoginPage() throws IllegalAccessException {

        MainMenu mainMenu = new MainMenu(testUtil.getDriver());
        mainMenu.click("Moje konto");
    }

    @When("The user types a correct email address {string}")
    @When("The user types an incorrect username {string}")
    @When("The user types an incorrect email address {string}")
    public void theUserTypesAnIncorrectUsername(String data) throws IllegalAccessException {

        loginForm.setUsername(data);
    }

    @And("Types a correct password {string}")
    @And("Types an incorrect password {string}")
    public void andTypesACorrectPassword(String password) throws IllegalAccessException {

        loginForm.setPassword(password);
    }

    @And("The user leaves the username or password field blank")
    public void leavesTheUsernameOrEmailAddressField() throws IllegalAccessException {

        loginForm.setUsername("");
    }


    @And("Leaves the password field blank")
    public void leavesThePasswordField() throws IllegalAccessException {

        loginForm.setPassword("");
    }

    @And("Clicks the submit button")
    public void andClicksTheSubmitButton() throws IllegalAccessException {

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

    @Then("The user is logged in")
    public void theUserIsLoggedIn() {

        Account account = new Account(testUtil.getDriver());

        Assert.assertTrue(account.areNavigationButtonsVisible());
    }
}
