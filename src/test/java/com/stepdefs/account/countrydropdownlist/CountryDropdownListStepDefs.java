package com.stepdefs.account.countrydropdownlist;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.addressform.CountryDropdownList;

import static qa.driver.Driver.*;

public class CountryDropdownListStepDefs {

    private CountryDropdownList countryDropdownList;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Then("The message about incorrect country name is displayed")
    public void messageIsDisplayed() {

        Assert.assertTrue(countryDropdownList.isMessageDisplayed());
    }

    @Then("The message about incorrect country name is not displayed")
    public void messageIsNotDisplayed() {

        Assert.assertFalse(countryDropdownList.isMessageDisplayed());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
