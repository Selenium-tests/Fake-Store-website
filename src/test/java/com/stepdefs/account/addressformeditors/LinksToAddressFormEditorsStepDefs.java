package com.stepdefs.account.addressformeditors;

import qa.testutil.TestUtil;
import io.cucumber.java.en.When;
import qa.pages.account.Account;


public class LinksToAddressFormEditorsStepDefs {

    private final TestUtil testUtil;

    public LinksToAddressFormEditorsStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("An user clicks the symbol in the {string} column")
    public void anUserClicksTheButton(String column) throws IllegalAccessException {

        int index = column.equals("Adres rozliczeniowy") ? 0 : 1;

        Account account = new Account(testUtil.getDriver());
        account.getAddresses().clickAddButton(index);
    }
}
