package steps.shoppingCartFunctionalities;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.driver.Driver;
import qa.enums.Browser;
import qa.pages.ProductsContainer;
import qa.pages.ShoppingCart;
import qa.pages.SiteHeaderCart;
import qa.utils.PriceParser;

import static qa.driver.Driver.*;

public class ShoppingCartFunctionalitiesStepDefs {

    private ShoppingCart shoppingCart;
    private double expectedTotalPrice;

    @Before
    public void init() {

        Driver.createDriver(Browser.CHROME);
        startDriver();

        shoppingCart = new ShoppingCart(getDriver());
    }

    @Given("The product has been added to the shopping cart")
    public void theProductHasBeenAddedToTheShoppingCart() {

        ProductsContainer productsContainer = new ProductsContainer(getDriver());
        productsContainer.setProductThumbnail("Popularne", 1);
        productsContainer.getProductThumbnail().clickAddToCartButton();
        productsContainer.getProductThumbnail().waitForSeeCartButton();
    }

    @And("The shopping cart page is open")
    public void theShoppingCartPagesOpen() {

        SiteHeaderCart siteHeaderCart = new SiteHeaderCart(getDriver());
        siteHeaderCart.clickCartMenu();
    }

    @When("The user types the {string} as amount of the product")
    public void theUserTypesTheAmountOfTheProduct(String amount) {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().setAmount(amount);

        expectedTotalPrice = PriceParser.parse(shoppingCart.getRow().getPrice()) * Double.parseDouble(amount);
    }

    @When("The user clicks the 'Remove' button")
    public void theUserClicksTheRemoveButton() {

        shoppingCart.findProduct(0);
        shoppingCart.getRow().clickRemoveButton();
    }

    @And("Clicks the 'Zaktualizuj koszyk' button")
    public void clicksTheUpdateCartButton() throws InterruptedException {

        shoppingCart.clickUpdateCartButton();

        Thread.sleep(2000);
    }

    @Then("The amount of the product has been changed")
    public void theAmountOfTheProductHasBeenChanged() {

        shoppingCart.findProduct(0);
        double givenTotalPrice = PriceParser.parse(shoppingCart.getRow().getTotalPrice());

        Assert.assertEquals(givenTotalPrice, expectedTotalPrice);
    }

    @Then("The shopping cart is empty")
    public void theShoppingCartIsEmpty() {


    }
}
