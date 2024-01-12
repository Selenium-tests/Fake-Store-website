package com.commonstepdefs;

import io.cucumber.java.en.And;
import qa.enums.AddressFormMethods;
import qa.helpers.fillers.AddressFormFiller;
import qa.helpers.fillers.CreditCardFormFiller;
import qa.pages.checkout.CheckoutPage;
import qa.testutil.TestUtil;

import java.lang.reflect.InvocationTargetException;

public class CheckoutCommonSteps {

    private final TestUtil testUtil;

    public CheckoutCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @And("The payment details form is filled")
    public void paymentDetailsFormIsFilled() throws IllegalAccessException, InvocationTargetException {

        AddressFormFiller.fill(testUtil.getDriver(), AddressFormMethods.ALL);
    }

    @And("The credit card form is filled")
    public void creditCardFormIsFilled() {

        CreditCardFormFiller.fill(testUtil.getDriver());
    }

    @And("The checkout page is open")
    public void theCheckoutPageIsOpen() throws IllegalAccessException {

        testUtil.goToUrl("https://fakestore.testelka.pl/zamowienie/");
    }

    @And("Fills the credit card form")
    public void fillsTheCreditCardForm() {

        CreditCardFormFiller.fill(testUtil.getDriver());
    }

    @And("Accepts terms")
    public void acceptsTerms() throws IllegalAccessException {

        CheckoutPage checkoutPage = new CheckoutPage(testUtil.getDriver());
        checkoutPage.clickTermsCheckbox();
    }
}
