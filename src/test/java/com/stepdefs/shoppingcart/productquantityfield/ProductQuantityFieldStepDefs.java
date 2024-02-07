package com.stepdefs.shoppingcart.productquantityfield;

import qa.models.CartItemDetails;
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
    private CartItemDetails cartItemDetails;

    public ProductQuantityFieldStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user types the {string} as quantity of the product")
    public void theUserTypesTheQuantityOfTheProduct(String quantity) {

        shoppingCart.getTable().findRows();
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);
        cartItemDetails = new CartItemDetails(quantity, shoppingCart.getTable().getProductPrice(0));
    }

    @When("The user types the {string} as not a number")
    public void theUserTypesNotANumber(String quantity) {

        shoppingCart.getTable().findRows();
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);
    }

    @Then("The amount of the product is correct")
    public void theAmountOfProductIsCorrect() {

        shoppingCart.getTable().findRows();
        double givenTotalPrice = PriceParser.parse(shoppingCart.getTable().getAmount(0));

        Assert.assertEquals(givenTotalPrice, cartItemDetails.getAmount(),
                "Incorrect amount");
    }

    @And("The quantity of the product is correct")
    public void quantityOfProductIsCorrect() {

        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getValue(), String.valueOf(cartItemDetails.getQuantity()),
                "Incorrect quantity of product");
    }

    @And("The validation message is displayed")
    public void theValidationMessageIsDisplayed() {

        try {
            shoppingCart.getTable().getQuantityField(0).waitForValidationMessage();
        } catch (Exception e) {
            Assert.fail("The validation message is not displayed");
        }

        System.out.println(shoppingCart.getTable().getQuantityField(0).getValidationMessageText());
    }
}
