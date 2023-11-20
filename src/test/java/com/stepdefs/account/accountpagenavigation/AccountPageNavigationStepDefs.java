package com.stepdefs.account.accountpagenavigation;

import com.testutil.TestUtil;
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

    @When("An user clicks the {string} link")
    public void anUserClicksTheLink(String link) throws IllegalAccessException {

        account = new Account(testUtil.getDriver());
        account.clickLink(link);
    }

    @Then("An user is logged out")
    public void anUserIsLoggedOut() {

        Assert.assertFalse(account.areNavigationButtonsVisible());
    }
}
