package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.productpage.ProductPage;
import qa.pages.productthumbnail.ProductThumbnail;
import qa.pages.productthumbnail.ThumbnailProvider;
import qa.pages.siteheadercart.SiteHeaderCart;
import qa.testutil.TestUtil;

public class ShoppingCartCommonSteps {

    private final TestUtil testUtil;

    public ShoppingCartCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("The product number {int} from the {string} category has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart(int productNumber, String category) throws IllegalAccessException {

        ProductThumbnail thumbnail = ThumbnailProvider.getThumbnail(testUtil.getDriver(), category, productNumber);
        thumbnail.clickTheProductLink();
        //ProductsContainer productsContainer = new ProductsContainer(testUtil.getDriver());
        //productsContainer.setProductThumbnail(category, productNumber);
        //productsContainer.getProductThumbnail().clickTheProductLink();

        ProductPage productPage = new ProductPage(testUtil.getDriver());
        productPage.clickAddToCartButton();
    }

    @And("The shopping cart page is open")
    public void theShoppingCartPagesIsOpen() throws IllegalAccessException {

        SiteHeaderCart siteHeaderCart = new SiteHeaderCart(testUtil.getDriver());
        siteHeaderCart.clickCartMenu();
    }
}
