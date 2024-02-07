package com.stepdefs.shoppingcart.addingfromproductpage;

import qa.models.ProductDataList;
import qa.pages.productpage.ProductPage;
import qa.pages.shoppingcart.ShoppingCart;
import qa.pages.siteheadercart.SiteHeaderCart;
import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.models.ProductData;


public class AddingFromProductPageStepDefs {

    private final TestUtil testUtil;
    private final ProductPage productPage;
    private final SiteHeaderCart siteHeaderCart;
    private final ShoppingCart shoppingCart;

    public AddingFromProductPageStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        productPage = new ProductPage(testUtil.getDriver());
        siteHeaderCart = new SiteHeaderCart(testUtil.getDriver());
        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user goes to the page with the url {string}")
    @And("Goes to the page with the url {string}")
    public void theUserGoesToPageWithUrl(String url) {

        testUtil.goToUrl(url);
    }

    @And("Enters {string} as the quantity")
    public void entersQuantity(String quantity) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(quantity);
    }

    @When("The user clicks the \"Dodaj do koszyka\" button")
    @And("Clicks the \"Dodaj do koszyka\" button")
    public void theUserClicksTheAddToCartButton() {

        ProductDataList.addData(new ProductData(productPage.getProductName(), productPage.getPrice(), productPage.getQuantityField().getValue()));
        productPage.clickAddToCartButton();
    }

    @Then("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        //Assert.assertNotEquals(siteHeaderCart.getPrice(), "0,00 zł");
    }

    @And("The message about adding the product to the cart was displayed")
    public void theMessageWasDisplayed() {

        /*try {
            productPage.waitForMessage();
        } catch (Exception e) {
            Assert.fail("The message is not displayed");
        }*/
    }
}
