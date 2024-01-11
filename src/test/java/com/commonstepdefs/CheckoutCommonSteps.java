package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import qa.enums.AddressFormMethods;
import qa.enums.CreditCardFormMethods;
import qa.helpers.fillers.AddressFormFiller;
import qa.helpers.fillers.CreditCardFormFiller;
import qa.pages.shoppingcart.ShoppingCart;
import qa.pages.checkout.CheckoutPage;
import qa.testutil.TestUtil;

import java.lang.reflect.InvocationTargetException;

public class CheckoutCommonSteps {

    private final TestUtil testUtil;

    public CheckoutCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @And("The checkout page is open")
    public void theCheckoutPageIsOpen() throws IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @And("Fills the credit card form")
    public void fillsTheCreditCardForm() {

        CreditCardFormFiller.fill(testUtil.getDriver(), CreditCardFormMethods.ALL);
    }

    @And("Fills the payment details form")
    public void fillsThePaymentDetailsForm() throws IllegalAccessException, InvocationTargetException {

        AddressFormFiller.fill(testUtil.getDriver(), AddressFormMethods.ALL);
    }

    @And("Accepts terms")
    public void acceptsTerms() throws IllegalAccessException {

        CheckoutPage checkoutPage = new CheckoutPage(testUtil.getDriver());
        checkoutPage.clickTermsCheckbox();
    }
}
