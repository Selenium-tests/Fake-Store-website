package com.stepdefs.checkout.addressform;

import qa.enums.AddressFormMethods;
import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import qa.helpers.fillers.AddressFormFiller;

import java.lang.reflect.InvocationTargetException;

public class AddressFormStepDefs {

    private final TestUtil testUtil;

    public AddressFormStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    private void fillAddressForm(AddressFormMethods omitted) throws InvocationTargetException, IllegalAccessException {

        AddressFormFiller.fill(testUtil.getDriver(), omitted);
    }

    @And("Fills the address form leaving the 'Imię' field blank")
    public void fillsTheAddressFormLeavesTheFirstNameFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_FIRST_NAME);
    }

    @And("Fills the address form leaving the 'Nazwisko' field blank")
    public void fillsTheAddressFormLeavesTheLastNameFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_LAST_NAME);
    }

    @And("Fills the address form leaving the 'Ulica' field blank")
    public void fillsTheAddressFormLeavesTheAddressFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_ADDRESS_1);
    }

    @And("Fills the address form leaving the 'Kod pocztowy' field blank")
    public void fillsTheAddressFormLeavesThePostcodeFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_POSTCODE);
    }

    @And("Fills the address form leaving the 'Miasto' field blank")
    public void fillsTheAddressFormLeavesTheCItyFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_CITY);
    }

    @And("Fills the address form leaving the 'Telefon' field blank")
    public void fillsTheAddressFormLeavesThePhoneFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_PHONE);
    }

    @And("Fills the address form leaving the 'Adres email' field blank")
    public void fillsTheAddressFormLeavesTheEmailFieldBlank() throws IllegalAccessException, InvocationTargetException {

        fillAddressForm(AddressFormMethods.SET_EMAIL);
    }
}
