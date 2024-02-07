package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import qa.pages.animation.Animation;
import qa.enums.URLs;
import qa.models.ProductDataList;
import qa.pages.productpage.ProductPage;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;
import qa.models.ProductData;
import qa.models.ThumbnailData;
import qa.support.ThumbnailDataProvider;

import java.util.List;

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

    @And("Clicks the 'Zaktualizuj koszyk' button")
    public void clicksTheUpdateCartButton() throws IllegalAccessException {

        shoppingCart.clickUpdateCartButton();

        Animation animation = new Animation(testUtil.getDriver());
        animation.waitUntilIsInvisible();
    }

    @Then("The shopping cart is not empty")
    public void shoppingCartIsNotEmpty() {

        testUtil.goToUrl(URLs.SHOPPING_CART.getName());
        shoppingCart.getTable().findRows();

        Assert.assertTrue(shoppingCart.getTable().getRowsCount() > 0,
                "The shopping cart is empty");
    }

    @Then("The shopping cart is empty")
    public void shoppingCartIsEmpty() {

        try {
            shoppingCart.getTable().waitForTable();
            Assert.fail("The shopping cart is not empty");
        } catch (Exception ignored) {

        }
    }

    @And("The number of products is correct")
    public void numberOfProductsIs() {

        Assert.assertEquals(shoppingCart.getTable().getRowsCount(), ProductDataList.getProducts().size(),
                "Incorrect number of products in the shopping cart");
    }

    @And("Product data matches the data displayed on the product page")
    public void productDataMatches() {

        List<ProductData> data = ProductDataList.getProducts();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < data.size(); i++) {

            softAssert.assertEquals(shoppingCart.getTable().getProductName(i), data.get(i).getName());
            softAssert.assertEquals(shoppingCart.getTable().getProductPrice(i), data.get(i).getPrice());
            softAssert.assertEquals(shoppingCart.getTable().getQuantityField(i).getValue(), data.get(i).getQuantity());
        }
    }

    @And("The message about empty shopping cart is displayed")
    public void theMessageAboutEmptyShoppingCartIsDisplayed() {

        Assert.assertTrue(shoppingCart.hasMessageListMoreThanOneElement());
    }

    @And("The empty shopping cart message is: {string}")
    public void theEmptyShoppingCartMessageIs(String message) {

        Assert.assertEquals(shoppingCart.getEmptyCartMessageText(), message);
    }
}
