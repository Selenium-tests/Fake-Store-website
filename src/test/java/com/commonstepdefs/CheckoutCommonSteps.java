package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import qa.factories.AddressFormFactory;
import qa.factories.CreditCardFormFactory;
import qa.pages.ShoppingCart;
import qa.pages.checkout.CheckoutPage;

import static qa.driver.Driver.getDriver;

public class CheckoutCommonSteps {

    @When("The user clicks the 'Przejdź do płatności' button")
    public void theUserClicksTheButton() {

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @And("Fills the credit card form")
    public void fillsTheCreditCardForm() {

        CreditCardFormFactory.get(getDriver());
    }

    @And("Fills the payment details form")
    public void fillsThePaymentDetailsForm() {

        AddressFormFactory.get(getDriver());
    }

    @And("Accepts terms")
    public void acceptsTerms() {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        checkoutPage.clickTermsCheckbox();
    }
}
