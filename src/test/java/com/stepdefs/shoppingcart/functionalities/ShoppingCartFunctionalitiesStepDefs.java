package com.stepdefs.shoppingcart.functionalities;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.ShoppingCart;
import qa.utils.PriceParser;


public class ShoppingCartFunctionalitiesStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;
    private double expectedTotalPrice;

    public ShoppingCartFunctionalitiesStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user types the {string} as amount of the product")
    public void theUserTypesTheAmountOfTheProduct(String amount) {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().setAmount(amount);

        expectedTotalPrice = PriceParser.parse(shoppingCart.getRow().getPrice()) * Double.parseDouble(amount);
    }

    @When("The user clicks the 'Remove' button")
    public void theUserClicksTheRemoveButton() throws InterruptedException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().clickRemoveButton();

        Thread.sleep(2000);
    }

    @And("Clicks the 'Zaktualizuj koszyk' button")
    public void clicksTheUpdateCartButton() throws InterruptedException {

        shoppingCart.clickUpdateCartButton();

        Thread.sleep(2000);
    }

    @Then("The amount of the product has been changed")
    public void theAmountOfTheProductHasBeenChanged() {

        shoppingCart.findProduct(0);
        double givenTotalPrice = PriceParser.parse(shoppingCart.getRow().getTotalPrice());

        Assert.assertEquals(givenTotalPrice, expectedTotalPrice);
    }

    @Then("The shopping cart is empty")
    public void theShoppingCartIsEmpty() {

        Assert.assertFalse(shoppingCart.isContentsLocatorPresent());
    }

    @And("The message {string} has been displayed")
    public void theMessageHasBeenDisplayed(String message) {

        Assert.assertTrue(shoppingCart.isEmptyCartMessageVisible());
        Assert.assertEquals(shoppingCart.getEmptyCartMessageText(), message);
    }
}
