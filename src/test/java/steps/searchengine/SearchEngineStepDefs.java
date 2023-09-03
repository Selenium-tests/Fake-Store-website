package steps.searchengine;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.Products;
import qa.pages.SearchEngine;
import static qa.driver.Driver.createDriver;
import static qa.driver.Driver.startDriver;
import static qa.driver.Driver.getDriver;
import static qa.driver.Driver.quitDriver;

public class SearchEngineStepDefs {

    private SearchEngine searchEngine;
    private Products products;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
    }

    @Given("The user is on the home page")
    public void theUserIsOnTheHomePage() {

        searchEngine = new SearchEngine(getDriver());
        products = new Products(getDriver());
    }

    @When("The user clicks on the search engine field")
    public void theUserClicksOnTheSearchEngineField() throws InterruptedException {

        searchEngine.clickOnTheSearchField();
    }

    @And("Enters the '{string}' phrase")
    public void entersThePhrase(String phrase) {

        searchEngine.enterPhrase(phrase);
    }

    @And("Presses the ENTER key")
    public void pressesTheEnterKey() {

        searchEngine.submit();
    }

    @Then("The placeholder disappears")
    public void thePlaceholderDisappears() {

        Assert.assertEquals(searchEngine.getPlaceholderText(), "");
    }

    @Then("The products count text is present")
    public void theProductsCountTextIsPresent() {

        Assert.assertFalse(products.isResultCountEmpty());
    }

    @Then("The products count text is not present")
    public void theProductsCountTextIsNotPresent() {

        Assert.assertTrue(products.isResultCountEmpty());
    }

    @And("Products count text is 'Wyświetlanie wszystkich wyników: {int}'")
    public void productsCountTextIs(int numberOfProducts) {

        String expected = "Wyświetlanie wszystkich wyników: " + String.valueOf(numberOfProducts);

        Assert.assertEquals(products.getResultCountText(), expected);
    }

    @And("The number of products is {int}")
    public void theNumberOfProductsIs(int numberOfProducts) {

        Assert.assertEquals(products.getProductsColumnsSize(), numberOfProducts);
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
