package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.productpage.ProductPage;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;
import qa.utils.ConditionalUrlNavigator;
import qa.utils.ProductData;

public class ShoppingCartCommonSteps {

    private final TestUtil testUtil;
    private final ShoppingCart shoppingCart;

    public ShoppingCartCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;

        shoppingCart = new ShoppingCart(testUtil.getDriver());
    }

    @Given("The shopping cart is open")
    @And("The shopping cart page is open")
    public void theShoppingCartPagesIsOpen() {

        testUtil.goToUrl("https://fakestore.testelka.pl/koszyk/");
    }

    @Given("The product has been added to the shopping cart")
    public void productHasBeenAddedToShoppingCart() {

        testUtil.goToUrl("https://fakestore.testelka.pl/product/gran-koscielcow/");

        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();
    }

    @Then("The shopping cart is not empty")
    @And("The opened shopping cart is not empty")
    public void shoppingCartIsNotEmpty() {

        ConditionalUrlNavigator.openIfUrlIsNot(testUtil, "https://fakestore.testelka.pl/koszyk/");

        Assert.assertFalse(shoppingCart.isEmptyCartMessageVisible());
    }

    @And("Product name and price match")
    public void productNameAndPriceMatch() {

        shoppingCart.findProduct(0);

        Assert.assertEquals(shoppingCart.getRow().getName(), ProductData.getName());
        Assert.assertEquals(shoppingCart.getRow().getPrice(), ProductData.getPrice());
    }
}
