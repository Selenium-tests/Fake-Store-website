package com.stepdefs.shoppingcart.productquantityfield;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.shoppingcart.ShoppingCart;
import qa.support.PriceParser;


public class ProductQuantityFieldStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;
    private double expectedTotalPrice;

    public ProductQuantityFieldStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user types the {string} as quantity of the product")
    public void theUserTypesTheQuantityOfTheProduct(String quantity) throws IllegalAccessException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().setQuantity(quantity);

        expectedTotalPrice = PriceParser.parse(shoppingCart.getRow().getPrice()) * Double.parseDouble(quantity);
    }

    @When("The user types the {string} as not a number")
    public void theUserTypesNotANumber(String quantity) throws IllegalAccessException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().setQuantity(quantity);
    }

    @Then("The quantity of the product has been changed")
    public void theQuantityOfTheProductHasBeenChanged() throws IllegalAccessException {

        shoppingCart.findProduct(0);
        double givenTotalPrice = PriceParser.parse(shoppingCart.getRow().getTotalPrice());

        Assert.assertEquals(givenTotalPrice, expectedTotalPrice);
    }

    @Then("The message about incorrect quantity value is displayed")
    public void theAlertIsPresent() {

        Assert.assertTrue(shoppingCart.getRow().isValidationMessageVisible());
    }

    @And("The validation message is: {string}")
    public void theValidationMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getRow().getValidationMessageText(), message);
    }
}
