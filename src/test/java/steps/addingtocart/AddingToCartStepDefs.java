package steps.addingtocart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.MainMenu;
import qa.pages.ProductPage;
import qa.pages.ProductsContainer;
import qa.pages.ShoppingCart;


import static qa.driver.Driver.*;

public class AddingToCartStepDefs {

    private MainMenu mainMenu;
    private ProductsContainer productsContainer;
    private String productTitle;
    private String price;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
    }

    @Given("The user is on the home page")
    public void theUserIsOnTheHomePage() {

        mainMenu = new MainMenu(getDriver());
        productsContainer = new ProductsContainer(getDriver());
    }

    @When("The user clicks the 'Dodaj do koszyka' button of {int} product from category: {string}")
    public void theUserClicksTheAddToCartButton(int productNumber, String category) throws InterruptedException {

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

        productTitle = productPage.getProductTitle();
        price = productPage.getPrice();

        Thread.sleep(3000);
    }

    @Then("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        Assert.assertNotEquals(mainMenu.getPrice(), "0,00 zł");
    }

    @And("The product is in the shopping cart")
    public void theProductIsInTheShoppingCart() {

        mainMenu.clickSiteHeaderCart();
        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.findProduct(0);

        System.out.println(productTitle);
        System.out.println(price);
        System.out.println("-------");
        System.out.println(shoppingCart.getRow().getName());
        System.out.println(shoppingCart.getRow().getPrice());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
