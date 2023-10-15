package com.stepdefs.account.accountpagenavigation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.account.Account;

import static qa.driver.Driver.*;

public class AccountPageNavigationStepDefs {

    Account account;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        account = new Account(getDriver());
    }

    @When("An user clicks the {string} link")
    public void anUserClicksTheLink(String link) {

        account = new Account(getDriver());
        account.clickLink(link);
    }

    @Then("An user is logged out")
    public void anUserIsLoggedOut() {

        Assert.assertFalse(account.areNavigationButtonsVisible());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
