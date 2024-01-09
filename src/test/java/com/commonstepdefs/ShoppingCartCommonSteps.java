package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.productpage.ProductPage;
import qa.testutil.TestUtil;

public class ShoppingCartCommonSteps {

    private final TestUtil testUtil;

    public ShoppingCartCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("A product is in the shopping cart")
    public void productIsInTheShoppingCart() throws IllegalAccessException {

        testUtil.goToUrl("https://fakestore.testelka.pl/product/windsurfing-w-lanzarote-costa-teguise/");
        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();
    }

    @And("The shopping cart page is open")
    public void theShoppingCartPagesIsOpen() {

        testUtil.goToUrl("https://fakestore.testelka.pl/koszyk/");
    }
}
