package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.account.Account;
import qa.pages.addressform.AddressForm;
import qa.pages.addressform.CountryDropdownList;
import qa.testutil.TestUtil;

public class AddressFormCommonSteps {

    private final TestUtil testUtil;

    public AddressFormCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @And("Goes to the \"Adres rozliczeniowy\" form")
    @And("The \"Adres rozliczeniowy\" form is open")
    public void goesToTheAddressForm() throws IllegalAccessException {

        Account account = new Account(testUtil.getDriver());
        account.clickLink("Adres");
        account.hideNotice();

        account.getAddresses().clickAddButton(0);
    }

    @When("An user clicks the country drop-down list arrow")
    public void clicksTheCountryDropDownListArrow() throws IllegalAccessException {

        CountryDropdownList countryDropdownList = new CountryDropdownList(testUtil.getDriver());
        countryDropdownList.clickArrow();
    }

    @And("Types {string} in the drop-down search field")
    public void typesCountryInTheDropdownListSearchField(String country) throws IllegalAccessException {

        CountryDropdownList countryDropdownList = new CountryDropdownList(testUtil.getDriver());
        countryDropdownList.setCountry(country);
    }

    @And("Presses the ENTER key")
    public void pressesEnter() throws IllegalAccessException {

        CountryDropdownList countryDropdownList = new CountryDropdownList(testUtil.getDriver());
        countryDropdownList.submit();
    }

    @Then("The message about blank 'Imię' field has been displayed")
    @Then("The message about blank 'Nazwisko' field has been displayed")
    @Then("The message about blank 'Ulica' field has been displayed")
    @Then("The message about blank 'Kod pocztowy' field has been displayed")
    @Then("The message about blank 'Miasto' field has been displayed")
    @Then("The message about blank 'Telefon' field has been displayed")
    @Then("The message about blank 'Adres email' field has been displayed")
    public void messageHasBeenDisplayed() {

        AddressForm addressForm = new AddressForm(testUtil.getDriver(), "billing");

        Assert.assertTrue(addressForm.isErrorMessageDisplayed());
    }

    @And("The error message text is {string}")
    public void theErrorMessageTextIs(String message) {

        AddressForm addressForm = new AddressForm(testUtil.getDriver(), "billing");

        Assert.assertEquals(addressForm.getErrorMessageText(), message);
    }
}
