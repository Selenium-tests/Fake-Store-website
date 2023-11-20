package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.ProductsContainer;
import qa.pages.SiteHeaderCart;

import static qa.driver.Driver.*;
public class ShoppingCartCommonSteps {

    @Given("The product number {int} from the {string} category has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart(int productNumber, String category) {

        ProductsContainer productsContainer = new ProductsContainer(getDriver());
        productsContainer.setProductThumbnail(category, productNumber);
        productsContainer.getProductThumbnail().clickAddToCartButton();
        productsContainer.getProductThumbnail().waitForSeeCartButton();
    }

    @And("The shopping cart page is open")
    public void theShoppingCartPagesIsOpen() throws IllegalAccessException {

        SiteHeaderCart siteHeaderCart = new SiteHeaderCart(getDriver());
        siteHeaderCart.clickCartMenu();
    }
}
