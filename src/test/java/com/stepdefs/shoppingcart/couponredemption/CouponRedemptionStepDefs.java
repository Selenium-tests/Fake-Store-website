package com.stepdefs.shoppingcart.couponredemption;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.ShoppingCart;


public class CouponRedemptionStepDefs {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;
    private String usedCouponCode;

    public CouponRedemptionStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }


    @And("Waits for 2 seconds")
    public void waitsFor2Seconds() throws InterruptedException {

        Thread.sleep(2000);
    }

    @When("An user clicks on the coupon code field")
    @And("Clicks on the coupon code field")
    public void anUserClicksOnTheCouponCodeField() throws IllegalAccessException {

        shoppingCart.getCouponForm().clickCouponCodeField();
    }

    @And("Enters the {string} as a coupon code")
    @And("Enters the {string} as a coupon code again")
    public void entersTheStringAsACouponCode(String couponCode) throws IllegalAccessException {

        shoppingCart.getCouponForm().setCouponCode(couponCode);
        usedCouponCode = couponCode;
    }

    @And("Clicks the 'Zastosuj kupon' button")
    @And("Clicks the 'Zastosuj kupon' button leaving the coupon code field blank")
    public void clicksTheButton() throws IllegalAccessException {

        shoppingCart.getCouponForm().clickApplyCouponButton();
    }

    @Then("The {string} message has been displayed")
    public void theMessageHasBeenDisplayed(String message) {

        Assert.assertTrue(shoppingCart.isMessageVisible());
        Assert.assertEquals(shoppingCart.getMessageText(), message);
    }

    @And("The {string} coupon is displayed on the shopping cart summary")
    public void theCouponIsDisplayedOnTheShoppingCartSummary(String couponCode) {

        Assert.assertEquals(couponCode, shoppingCart.getShoppingCartSummary().getCouponDescription(usedCouponCode));
    }

    @Then("The {string} error message has been displayed")
    public void theErrorMessageHasBeenDisplayed(String message) {

        Assert.assertTrue(shoppingCart.isErrorMessageVisible());
        Assert.assertEquals(message, shoppingCart.getErrorMessageText());
    }
}
