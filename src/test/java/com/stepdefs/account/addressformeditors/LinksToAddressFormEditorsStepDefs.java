package com.stepdefs.account.addressformeditors;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import qa.enums.Browser;
import qa.pages.account.Account;

import static qa.driver.Driver.*;

public class LinksToAddressFormEditorsStepDefs {

    private Account account;

    @Before
    public void create() {

        createDriver(Browser.CHROME);
        startDriver();

        account = new Account(getDriver());
    }

    @When("An user clicks the symbol in the {string} column")
    public void anUserClicksTheButton(String column) {

        int index = column.equals("Adres rozliczeniowy") ? 0 : 1;

        account.getAddresses().clickAddButton(index);
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
