package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import qa.factories.AddressFormFactory;
import qa.factories.CreditCardFormFactory;
import qa.pages.ShoppingCart;
import qa.pages.checkout.CheckoutPage;
import qa.testutil.TestUtil;

public class CheckoutCommonSteps {

    private final TestUtil testUtil;

    public CheckoutCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks the 'Przejdź do płatności' button")
    public void theUserClicksTheButton() throws IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @And("The checkout page is open")
    public void theCheckoutPageIsOpen() throws IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @And("Fills the credit card form")
    public void fillsTheCreditCardForm() throws IllegalAccessException {

        CreditCardFormFactory.get(testUtil.getDriver());
    }

    @And("Fills the payment details form")
    public void fillsThePaymentDetailsForm() throws IllegalAccessException {

        AddressFormFactory.get(testUtil.getDriver());
    }

    @And("Accepts terms")
    public void acceptsTerms() throws IllegalAccessException {

        CheckoutPage checkoutPage = new CheckoutPage(testUtil.getDriver());

        checkoutPage.clickTermsCheckbox();
    }
}
