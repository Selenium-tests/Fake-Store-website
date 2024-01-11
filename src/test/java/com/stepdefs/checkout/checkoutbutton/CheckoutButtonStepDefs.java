package com.stepdefs.checkout.checkoutbutton;

import io.cucumber.java.en.When;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;

public class CheckoutButtonStepDefs {

    private final TestUtil testUtil;

    public CheckoutButtonStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks the 'Przejdź do płatności' button")
    public void theUserClicksTheButton() throws IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }
}
