package com.stepdefs.shoppingcart.functionalities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;

public class RemoveButtonStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;

    public RemoveButtonStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user clicks the 'Remove' button")
    public void theUserClicksTheRemoveButton() throws IllegalAccessException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().clickRemoveButton();
    }

    @Then("The message about empty shopping cart is displayed")
    public void theMessageAboutEmptyShoppingCartIsDisplayed() {

        try {
            shoppingCart.waitForEmptyCartMessageLocator();
        } catch (Exception e) {
            Assert.fail("The message about empty shopping cart is not visible");
        }
    }

    @And("The empty shopping cart message is: {string}")
    public void theEmptyShoppingCartMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getEmptyCartMessageText(), message);
    }
}
