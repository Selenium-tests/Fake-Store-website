package com.stepdefs.shoppingcart.removingproducts;

import io.cucumber.java.en.When;
import qa.animation.CouponCodeRefreshLoader;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;

public class RemovingProductsStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;
    private final CouponCodeRefreshLoader couponCodeRefreshLoader;

    public RemovingProductsStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
        shoppingCart = new ShoppingCart(testUtil.getDriver());
        couponCodeRefreshLoader = new CouponCodeRefreshLoader(testUtil.getDriver());
    }

    @When("The user clicks the 'Remove' button")
    public void theUserClicksTheRemoveButton() {

        shoppingCart.getTable().findRows();
        shoppingCart.getTable().clickRemoveButton(0);
    }

    @When("The user enters the zero value in the quantity field")
    public void userEnterZeroValue() throws IllegalAccessException {

        shoppingCart.getTable().findRows();
        shoppingCart.getTable().getQuantityField(0).setQuantity("0");
        shoppingCart.clickUpdateCartButton();
    }
}
