package com.stepdefs.account.accountpagenavigation;

import qa.testutil.TestUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.account.Account;


public class AccountPageNavigationStepDefs {

    private final TestUtil testUtil;
    Account account;

    public AccountPageNavigationStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks the {string} link")
    public void userClicksTheLink(String link) throws IllegalAccessException {

        account = new Account(testUtil.getDriver());
        account.clickLink(link);
    }

    @Then("The user is logged out")
    public void userIsLoggedOut() {

        Assert.assertFalse(account.areNavigationButtonsVisible());
    }
}
