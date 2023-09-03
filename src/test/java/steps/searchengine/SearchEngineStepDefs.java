package steps.searchengine;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.SearchEngine;
import static qa.driver.Driver.createDriver;
import static qa.driver.Driver.startDriver;
import static qa.driver.Driver.getDriver;
import static qa.driver.Driver.quitDriver;

public class SearchEngineStepDefs {

    private SearchEngine searchEngine;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
    }

    @Given("The user is on the home page")
    public void theUserIsOnTheHomePage() {

        searchEngine = new SearchEngine(getDriver());
    }

    @When("The user clicks on the search engine field")
    public void theUserClicksOnTheSearchEngineField() throws InterruptedException {

        searchEngine.clickOnTheSearchField();
    }

    @Then("The placeholder disappears")
    public void thePlaceholderDisappears() {

        Assert.assertEquals(searchEngine.getPlaceholderText(), "");
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
