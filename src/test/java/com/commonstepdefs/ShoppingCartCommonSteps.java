package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import qa.pages.shoppingcart.ShoppingCart;
import qa.testutil.TestUtil;
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

    @And("The shopping cart is not empty")
    public void shoppingCartIsNotEmpty() {

        testUtil.goToUrl("https://fakestore.testelka.pl/koszyk/");

        Assert.assertFalse(shoppingCart.isEmptyCartMessageVisible());
    }

    @And("Product name and price match")
    public void productNameAndPriceMatch() {

        shoppingCart.findProduct(0);

        Assert.assertEquals(shoppingCart.getRow().getName(), ProductData.getName());
        Assert.assertEquals(shoppingCart.getRow().getPrice(), ProductData.getPrice());
    }
}
