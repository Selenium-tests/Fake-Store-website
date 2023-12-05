package com.stepdefs.shoppingcart.productquantityfield;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.ShoppingCart;
import qa.utils.PriceParser;


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

    @When("The user clicks the 'Remove' button")
    public void theUserClicksTheRemoveButton() throws InterruptedException, IllegalAccessException {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().clickRemoveButton();

        Thread.sleep(2000);
    }

    @And("Clicks the 'Zaktualizuj koszyk' button")
    public void clicksTheUpdateCartButton() throws InterruptedException, IllegalAccessException {

        shoppingCart.clickUpdateCartButton();

        Thread.sleep(2000);
    }

    @Then("The quantity of the product has been changed")
    public void theQuantityOfTheProductHasBeenChanged() {

        shoppingCart.findProduct(0);
        double givenTotalPrice = PriceParser.parse(shoppingCart.getRow().getTotalPrice());

        Assert.assertEquals(givenTotalPrice, expectedTotalPrice);
    }

    @Then("The message about empty shopping cart is displayed")
    public void theMessageAboutEmptyShoppingCartIsDisplayed() {

        Assert.assertTrue(shoppingCart.isEmptyCartMessageVisible());
    }

    @Then("The message about incorrect quantity value is displayed")
    public void theAlertIsPresent() {

        Assert.assertTrue(shoppingCart.getRow().isValidationMessageVisible());
    }

    @Then("The shopping cart is empty")
    public void theShoppingCartIsEmpty() {

        Assert.assertFalse(shoppingCart.isContentsLocatorPresent());
    }

    @And("The validation message is: {string}")
    public void theValidationMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getRow().getValidationMessageText(), message);
    }

    @And("The empty shopping cart message is: {string}")
    public void theEmptyShoppingCartMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getEmptyCartMessageText(), message);
    }
}
