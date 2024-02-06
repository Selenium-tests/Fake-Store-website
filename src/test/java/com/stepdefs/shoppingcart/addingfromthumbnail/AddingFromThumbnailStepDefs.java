package com.stepdefs.shoppingcart.addingfromthumbnail;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.URLs;
import qa.pages.productthumbnail.ProductThumbnail;
import qa.pages.productthumbnail.ThumbnailProvider;
import qa.testutil.TestUtil;
import qa.models.ProductData;
import qa.models.ThumbnailData;
import qa.support.ThumbnailDataProvider;

public class AddingFromThumbnailStepDefs {

    private final TestUtil testUtil;
    private ProductThumbnail productThumbnail;

    public AddingFromThumbnailStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
        productThumbnail = new ProductThumbnail(testUtil.getDriver());
    }

    @When("The user clicks the \"Dodaj do koszyka\" button of the {string} product thumbnail")
    public void theUserClicksTheAddToCartButton(String productName) {

        ThumbnailData thumbnailData = ThumbnailDataProvider.getThumbnailData(productName);

        productThumbnail = ThumbnailProvider.getThumbnail(testUtil.getDriver(), thumbnailData);
        productThumbnail.clickAddToCartButton();

        ProductData.setName(productThumbnail.getName());
        ProductData.setPrice(productThumbnail.getPrice());
    }

    @And("Clicks the \"Zobacz koszyk\" button")
    public void clicksSeeCartButton() {

        productThumbnail.clickSeeCartButton();
    }

    @Then("The \"Zobacz koszyk\" button is visible")
    public void theSeeCartButtonIsVisible() {

        try {
            productThumbnail.waitForSeeCartButton();
        } catch (Exception e) {
            Assert.fail("The \"Zobacz koszyk\" button is not visible");
        }
    }

    @Then("The shopping cart has been opened")
    public void shoppingCartHasBeenOpened() {

        Assert.assertEquals(testUtil.getDriver().getCurrentUrl(), URLs.SHOPPING_CART.getName());
    }
}
