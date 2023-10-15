package com.stepdefs.account.fillingaddressform;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.addressform.AddressForm;

import static qa.driver.Driver.*;

public class FillingAddressForm {

    private AddressForm addressForm;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        addressForm = new AddressForm(getDriver(), "billing");
    }

    @And("Types {string} as first name")
    public void anUserTypesFirstName(String firstName) {

        addressForm.setFirstName(firstName);
    }

    @And("Types {string} as last name")
    public void anUserTypesLastName(String lastName) {

        addressForm.setLastName(lastName);
    }

    @And("Types {string} as a company")
    public void anUserTypesCompany(String company) {

        addressForm.setCompany(company);
    }

    @And("Types {string} as an address")
    public void anUserTypesStreet(String address) {

        addressForm.setAddress1(address);
    }

    @And("Types {string} as a postcode")
    public void anUserTypesPostcode(String postcode) {

        addressForm.setPostcode(postcode);
    }

    @And("Types {string} as a city")
    public void anUserTypesCity(String city) {

        addressForm.setCity(city);
    }

    @And("Types {string} as a phone number")
    public void anUserTypesPhoneNumber(String phoneNumber) {

        addressForm.setPhone(phoneNumber);
    }

    @And("Types {string} as a email")
    public void anUserTypesEmail(String email) {

        addressForm.setEmail(email);
    }

    @And("Clicks the \"Zapisz adres\" key")
    public void clicksTheKey() {

        addressForm.clickSubmitButton();
    }

    @Then("The data has been saved")
    public void theDataHasBeenSaved() {

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://fakestore.testelka.pl/moje-konto/edytuj-adres/");
    }

    @Then("The data has not been saved")
    public void theDataHasNotBeenSaved() {

        Assert.assertNotEquals(getDriver().getCurrentUrl(), "https://fakestore.testelka.pl/moje-konto/edytuj-adres/");
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
