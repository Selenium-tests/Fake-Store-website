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
    public void theUserClicksTheRemoveButton() throws InterruptedException, IllegalAccessException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().clickRemoveButton();

        Thread.sleep(2000);
    }

    @Then("The message about empty shopping cart is displayed")
    public void theMessageAboutEmptyShoppingCartIsDisplayed() {

        Assert.assertTrue(shoppingCart.isEmptyCartMessageVisible());
    }

    @Then("The shopping cart is empty")
    public void theShoppingCartIsEmpty() {

        Assert.assertFalse(shoppingCart.isContentsLocatorPresent());
    }

    @And("The empty shopping cart message is: {string}")
    public void theEmptyShoppingCartMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getEmptyCartMessageText(), message);
    }
}
