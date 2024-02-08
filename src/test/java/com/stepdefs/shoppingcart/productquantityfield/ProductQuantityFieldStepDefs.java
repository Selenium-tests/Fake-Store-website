package com.stepdefs.shoppingcart.productquantityfield;

import qa.models.CartItemDetails;
import qa.support.StringCalc;
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

    private void setValue(String quantity, String rhs, String operator) {

        String result = StringCalc.calculate(quantity, rhs, operator);
        shoppingCart.getTable().getQuantityField(0).setQuantity(result);
        cartItemDetails = new CartItemDetails(result, shoppingCart.getTable().getProductPrice(0));
    }

    @When("The user types quantity: {string}")
    public void userTypesQuantity(String quantity) {

        shoppingCart.getTable().findRows();
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);
    }

    @When("The user types quantity which is MIN - 1")
    public void userTypesQuantityWhichIsLessThanMin() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMin(), "0", "+");
    }

    @When("The user types quantity which is MIN")
    public void userTypesQuantityWhichIsMin() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMin(), "1", "+");
    }

    @When("The user types quantity which is MIN + 1")
    public void userTypesQuantityWhichIsGreaterThanMin() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMin(), "2", "+");
    }

    @When("The user types quantity which is MAX - 1")
    public void userTypesQuantityWhichLessThanMax() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMax(), "1", "-");
    }

    @When("The user types quantity which is MAX")
    public void userTypesQuantityWhichIsMax() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMax(), "0", "+");
    }

    @When("The user types quantity which is MAX + 1")
    public void userTypesQuantityWhichGreaterThanMax() {

        shoppingCart.getTable().findRows();
        setValue(shoppingCart.getTable().getQuantityField(0).getMax(), "1", "+");
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
    }
}
