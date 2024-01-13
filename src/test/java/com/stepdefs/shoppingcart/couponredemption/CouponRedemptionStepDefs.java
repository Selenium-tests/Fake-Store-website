package com.stepdefs.shoppingcart.couponredemption;

import qa.animation.CouponCodeRefreshLoader;
import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.shoppingcart.ShoppingCart;


public class CouponRedemptionStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;
    private final CouponCodeRefreshLoader couponCodeRefreshLoader;
    private String usedCouponCode;

    public CouponRedemptionStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
        couponCodeRefreshLoader = new CouponCodeRefreshLoader(testUtil.getDriver());
    }

    @When("An user clicks on the coupon code field")
    @And("Clicks on the coupon code field")
    public void anUserClicksOnTheCouponCodeField() throws IllegalAccessException {

        shoppingCart.getCouponForm().clickCouponCodeField();
    }

    @And("Enters the {string} as a coupon code")
    public void entersCouponCode(String couponCode) {

        shoppingCart.getCouponForm().setCouponCode(couponCode);
        usedCouponCode = couponCode;
    }

    @And("Enters the used {string} coupon code")
    public void entersUsedCouponCode(String couponCode) throws IllegalAccessException {

        couponCodeRefreshLoader.waitUntilLoaderIsInvisible();
        shoppingCart.getCouponForm().setCouponCode(couponCode);
    }

    @And("Clicks the 'Zastosuj kupon' button")
    @And("Clicks the 'Zastosuj kupon' button leaving the coupon code field blank")
    public void clicksTheButton() throws IllegalAccessException {

        shoppingCart.getCouponForm().clickApplyCouponButton();
    }

    @Then("The {string} message has been displayed")
    public void theMessageHasBeenDisplayed(String message) {

        try {
            shoppingCart.waitForMessage();
        } catch (Exception e) {
            Assert.fail("The message is not visible");
        }

        Assert.assertEquals(shoppingCart.getMessageText(), message);
    }

    @And("The {string} coupon is displayed on the shopping cart summary")
    public void theCouponIsDisplayedOnTheShoppingCartSummary(String couponCode) {

        Assert.assertEquals(couponCode, shoppingCart.getShoppingCartSummary().getCouponDescription(usedCouponCode));
    }

    @Then("The {string} error message has been displayed")
    public void theErrorMessageHasBeenDisplayed(String message) {

        try {
            shoppingCart.waitForErrorMessage();
        } catch (Exception e) {
            Assert.fail("The error message is not visible");
        }

        Assert.assertEquals(shoppingCart.getErrorMessageText(), message);
    }
}
