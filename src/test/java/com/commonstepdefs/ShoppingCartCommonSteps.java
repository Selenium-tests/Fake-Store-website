package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.enums.URLs;
import qa.pages.productpage.ProductPage;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;
import qa.utils.ConditionalUrlNavigator;
import qa.utils.ProductData;
import qa.utils.ThumbnailData;
import qa.utils.ThumbnailDataProvider;

public class ShoppingCartCommonSteps {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;

    public ShoppingCartCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @Given("The product: {string} is in the shopping cart")
    public void givenProductIsInTheShoppingCart(String productName) {

        ThumbnailData thumbnailData = ThumbnailDataProvider.getThumbnailData(productName);
        testUtil.goToUrl(thumbnailData.getProductPageUrl());

        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();
    }

    @Given("The shopping cart is open")
    @And("The shopping cart page is open")
    public void theShoppingCartPagesIsOpen() {

        testUtil.goToUrl(URLs.SHOPPING_CART.getName());
    }

    @Given("A product has been added to the shopping cart")
    public void productHasBeenAddedToShoppingCart() {

        testUtil.goToUrl(URLs.GRAN_KOSCIELCOW_PRODUCT_PAGE.getName());

        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();
    }

    @Then("The shopping cart is not empty")
    @And("The opened shopping cart is not empty")
    public void shoppingCartIsNotEmpty() {

        ConditionalUrlNavigator.openIfUrlIsNot(testUtil, URLs.SHOPPING_CART.getName());

        try {
            shoppingCart.waitForEmptyCartMessageLocator();
            Assert.fail("The message about empty shopping cart is visible");
        } catch (Exception ignored) {

        }
    }

    @And("Product name and price match")
    public void productNameAndPriceMatch() {

        shoppingCart.findProduct(0);

        Assert.assertEquals(shoppingCart.getRow().getName(), ProductData.getName());
        Assert.assertEquals(shoppingCart.getRow().getPrice(), ProductData.getPrice());
    }
}
