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
import qa.pages.ProductsContainer;


import static qa.driver.Driver.*;

public class AddingToCartStepDefs {

    private MainMenu mainMenu;
    private ProductsContainer productsContainer;

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

    @And("Waits until the 'Zobacz koszyk' button is visible")
    public void waitsUntilTheSeeCartButtonIsVisible() {

        productsContainer.getProductThumbnail().waitForSeeCartButton();
    }

    @Then("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        Assert.assertNotEquals(mainMenu.getPrice(), "0,00 zł");
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
