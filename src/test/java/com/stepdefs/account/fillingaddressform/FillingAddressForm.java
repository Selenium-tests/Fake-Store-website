package com.stepdefs.account.fillingaddressform;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.addressform.AddressForm;


public class FillingAddressForm {

    private final TestUtil testUtil;
    private final AddressForm addressForm;

    public FillingAddressForm(TestUtil testUtil) {

        this.testUtil = testUtil;

        addressForm = new AddressForm(testUtil.getDriver(), "billing");
    }

    @And("Types {string} as first name")
    public void anUserTypesFirstName(String firstName) throws IllegalAccessException {

        addressForm.setFirstName(firstName);
    }

    @And("Types {string} as last name")
    public void anUserTypesLastName(String lastName) throws IllegalAccessException {

        addressForm.setLastName(lastName);
    }

    @And("Types {string} as a company")
    public void anUserTypesCompany(String company) throws IllegalAccessException {

        addressForm.setCompany(company);
    }

    @And("Types {string} as an address")
    public void anUserTypesStreet(String address) throws IllegalAccessException {

        addressForm.setAddress1(address);
    }

    @And("Types {string} as a postcode")
    public void anUserTypesPostcode(String postcode) throws IllegalAccessException {

        addressForm.setPostcode(postcode);
    }

    @And("Types {string} as a city")
    public void anUserTypesCity(String city) throws IllegalAccessException {

        addressForm.setCity(city);
    }

    @And("Types {string} as a phone number")
    public void anUserTypesPhoneNumber(String phoneNumber) throws IllegalAccessException {

        addressForm.setPhone(phoneNumber);
    }

    @And("Types {string} as a email")
    public void anUserTypesEmail(String email) throws IllegalAccessException {

        addressForm.setEmail(email);
    }

    @And("Clicks the \"Zapisz adres\" key")
    public void clicksTheKey() throws IllegalAccessException {

        addressForm.clickSubmitButton();
    }

    @Then("The data has been saved")
    public void theDataHasBeenSaved() {

        Assert.assertEquals(testUtil.getDriver().getCurrentUrl(), "https://fakestore.testelka.pl/moje-konto/edytuj-adres/");
    }

    @Then("The data has not been saved")
    public void theDataHasNotBeenSaved() {

        Assert.assertNotEquals(testUtil.getDriver().getCurrentUrl(), "https://fakestore.testelka.pl/moje-konto/edytuj-adres/");
    }
}
