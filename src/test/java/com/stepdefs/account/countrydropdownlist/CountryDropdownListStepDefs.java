package com.stepdefs.account.countrydropdownlist;

import qa.testutil.TestUtil;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.addressform.CountryDropdownList;


public class CountryDropdownListStepDefs {

    private final TestUtil testUtil;
    private final CountryDropdownList countryDropdownList;


    public CountryDropdownListStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        countryDropdownList = new CountryDropdownList(testUtil.getDriver());
    }

    @Then("The message about incorrect country name is displayed")
    public void messageIsDisplayed() {

        Assert.assertTrue(countryDropdownList.isMessageDisplayed());
    }

    @Then("The message about incorrect country name is not displayed")
    public void messageIsNotDisplayed() {

        Assert.assertFalse(countryDropdownList.isMessageDisplayed());
    }
}
