package com.stepdefs.checkout.addressform;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import qa.factories.AddressFormFactory;

public class AddressFormStepDefs {

    private final TestUtil testUtil;

    public AddressFormStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @And("Fills the address form leaving the 'Imię' field blank")
    public void fillsTheAddressFormLeavesTheFirstNameFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutFirstName(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Nazwisko' field blank")
    public void fillsTheAddressFormLeavesTheLastNameFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutLastName(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Ulica' field blank")
    public void fillsTheAddressFormLeavesTheAddressFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutAddress(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Kod pocztowy' field blank")
    public void fillsTheAddressFormLeavesThePostcodeFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutPostcode(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Miasto' field blank")
    public void fillsTheAddressFormLeavesTheCItyFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutCity(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Telefon' field blank")
    public void fillsTheAddressFormLeavesThePhoneFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutPhone(testUtil.getDriver());
    }

    @And("Fills the address form leaving the 'Adres email' field blank")
    public void fillsTheAddressFormLeavesTheEmailFieldBlank() throws IllegalAccessException {

        AddressFormFactory.withoutEmail(testUtil.getDriver());
    }
}
