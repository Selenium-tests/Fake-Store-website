package steps.addingtocart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.*;


import static qa.driver.Driver.*;

public class AddingToCartStepDefs {

    private SiteHeaderCart siteHeaderCart;
    private ProductsContainer productsContainer;
    private ShoppingCart shoppingCart;
    private String productName;
    private String price;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        siteHeaderCart = new SiteHeaderCart(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
    }

    @Given("The user is on the home page")
    public void theUserIsOnTheHomePage() {

        productsContainer = new ProductsContainer(getDriver());
    }

    @When("The user clicks the 'Dodaj do koszyka' button of {int} product from category: {string}")
    public void theUserClicksTheAddToCartButton(int productNumber, String category) {

        productsContainer.setProductThumbnail(category, productNumber);
        productsContainer.getProductThumbnail().clickAddToCartButton();
    }

    @When("The user clicks on the {int} product link from the {string} category")
    public void theUserClicksOnTheProductFromCategory(int productNumber, String category) {

        productsContainer.setProductThumbnail(category, productNumber);
        productsContainer.getProductThumbnail().clickTheProductLink();
    }

    @And("Waits until the 'Zobacz koszyk' button is visible")
    public void waitsUntilTheSeeCartButtonIsVisible() {

        productsContainer.getProductThumbnail().waitForSeeCartButton();
    }

    @And("Clicks the 'Dodaj do koszyka' button")
    public void clicksTheAddToCartButton() throws InterruptedException {

        ProductPage productPage = new ProductPage(getDriver());
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
    public void theProductIsInTheShoppingCart() {

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

    @After
    public void tearDown() {

        quitDriver();
    }
}
