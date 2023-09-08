package steps.addingtocart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.enums.Browser;
import qa.pages.MainMenu;
import qa.pages.ProductsContainer;
//import qa.pages.NewProducts;
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
    public void theUserClicksTheAddToCartButton(int productNumber, String category) {

        productsContainer.setCategory(category);
        productsContainer.clickAddToCartButton(productNumber);
    }

    @Then("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        System.out.println(mainMenu.getCartContents());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
