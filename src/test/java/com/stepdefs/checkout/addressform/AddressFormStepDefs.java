package com.stepdefs.checkout.addressform;

import io.cucumber.java.en.When;
import qa.enums.AddressFormMethods;
import qa.testutil.TestUtil;
import qa.support.AddressFormHandler;

import java.lang.reflect.InvocationTargetException;

public class AddressFormStepDefs {

    private final TestUtil testUtil;

    public AddressFormStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    private void fillAddressForm(AddressFormMethods omitted) throws InvocationTargetException, IllegalAccessException {

        AddressFormHandler.fill(testUtil.getDriver(), omitted);
    }

    @When("The user fills the address form leaving the 'Imię' field blank")
    public void fillsTheAddressFormLeavesTheFirstNameFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_FIRST_NAME);
    }

    @When("The user fills the address form leaving the 'Nazwisko' field blank")
    public void fillsTheAddressFormLeavesTheLastNameFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_LAST_NAME);
    }

    @When("The user fills the address form leaving the 'Ulica' field blank")
    public void fillsTheAddressFormLeavesTheAddressFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_ADDRESS_1);
    }

    @When("The user fills the address form leaving the 'Kod pocztowy' field blank")
    public void fillsTheAddressFormLeavesThePostcodeFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_POSTCODE);
    }

    @When("The user fills the address form leaving the 'Miasto' field blank")
    public void fillsTheAddressFormLeavesTheCItyFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_CITY);
    }

    @When("The user fills the address form leaving the 'Telefon' field blank")
    public void fillsTheAddressFormLeavesThePhoneFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_PHONE);
    }

    @When("The user fills the address form leaving the 'Adres email' field blank")
    public void fillsTheAddressFormLeavesTheEmailFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_EMAIL);
    }
}
