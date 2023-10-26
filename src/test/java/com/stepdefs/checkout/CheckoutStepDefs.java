package com.stepdefs.checkout;

import com.testutil.TestUtil;
import io.cucumber.java.en.When;
import qa.pages.ShoppingCart;

public class CheckoutStepDefs {

    private final TestUtil testUtil;

    public CheckoutStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks the 'Przejdź do płatności' button")
    public void theUserClicksTheButton() {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }
}
