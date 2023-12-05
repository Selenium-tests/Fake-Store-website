package com.stepdefs.shoppingcart.addingproduct;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.*;


public class AddingToCartStepDefs {

    private final TestUtil testUtil;
    private final SiteHeaderCart siteHeaderCart;
    private final ProductsContainer productsContainer;
    private final ShoppingCart shoppingCart;
    private String productName;
    private String price;

    public AddingToCartStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        siteHeaderCart = new SiteHeaderCart(testUtil.getDriver());
        productsContainer = new ProductsContainer(testUtil.getDriver());
        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @When("The user clicks the 'Dodaj do koszyka' button of {int} product from category: {string}")
    public void theUserClicksTheAddToCartButton(int productNumber, String category) {

        productsContainer.setProductThumbnail(category, productNumber);
        productsContainer.getProductThumbnail().clickAddToCartButton();
    }

    @When("The user clicks on the {int} product link from the {string} category")
    public void theUserClicksOnTheProductFromCategory(int productNumber, String category) throws IllegalAccessException {

        productsContainer.setProductThumbnail(category, productNumber);
        productsContainer.getProductThumbnail().clickTheProductLink();
    }

    @And("Waits until the 'Zobacz koszyk' button is visible")
    public void waitsUntilTheSeeCartButtonIsVisible() {

        productsContainer.getProductThumbnail().waitForSeeCartButton();
    }

    @And("Clicks the 'Dodaj do koszyka' button")
    public void clicksTheAddToCartButton() throws InterruptedException, IllegalAccessException {

        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();

        productName = productPage.getProductTitle();
        price = productPage.getPrice();

        Thread.sleep(3000);
    }

    @Then("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        Assert.assertNotEquals(siteHeaderCart.getPrice(), "0,00 zł");
    }

    @And("The message about adding the product to the cart was displayed")
    public void theMessageWasDisplayed() {

        Assert.assertTrue(shoppingCart.isMessageVisible());
    }

    @And("The product is in the shopping cart")
    public void theProductIsInTheShoppingCart() throws IllegalAccessException {

        siteHeaderCart.clickCartMenu();
        shoppingCart.findProduct(0);

        Assert.assertTrue(shoppingCart.isContentsLocatorPresent());
        Assert.assertEquals(shoppingCart.getRow().getName(), productName);
        Assert.assertEquals(shoppingCart.getRow().getPrice(), price);
    }

    @And("Product name and price match")
    public void productNameAndPriceMatch() {

        shoppingCart.findProduct(0);

        Assert.assertEquals(shoppingCart.getRow().getName(), productName);
        Assert.assertEquals(shoppingCart.getRow().getPrice(), price);
    }
}
