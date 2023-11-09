package com.stepdefs.checkout.addressform;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.factories.AddressFormFactory;
import qa.pages.addressform.AddressForm;


public class AddressFormStepDefs {

    private final TestUtil testUtil;

    public AddressFormStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @And("Fills the address form leaving the 'Imię' field blank")
    public void fillsTheAddressFormLeavesTheFirstNameFieldBlank() {

        AddressFormFactory.withoutFirstName(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Nazwisko' field blank")
    public void fillsTheAddressFormLeavesTheLastNameFieldBlank() {

        AddressFormFactory.withoutLastName(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Ulica' field blank")
    public void fillsTheAddressFormLeavesTheAddressFieldBlank() {

        AddressFormFactory.withoutAddress(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Kod pocztowy' field blank")
    public void fillsTheAddressFormLeavesThePostcodeFieldBlank() {

        AddressFormFactory.withoutPostcode(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Miasto' field blank")
    public void fillsTheAddressFormLeavesTheCItyFieldBlank() {

        AddressFormFactory.withoutCity(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Telefon' field blank")
    public void fillsTheAddressFormLeavesThePhoneFieldBlank() {

        AddressFormFactory.withoutPhone(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Adres email' field blank")
    public void fillsTheAddressFormLeavesTheEmailFieldBlank() {

        AddressFormFactory.withoutEmail(testUtil.getDriver());
    }

    @Then("A message about not accepting the terms was displayed")
    public void messageAboutNotAcceptingTermsHasBeenDisplayed() {

        AddressForm addressForm = new AddressForm(testUtil.getDriver(), "billing");

        Assert.assertTrue(addressForm.isErrorMessageDisplayed());
    }
}
