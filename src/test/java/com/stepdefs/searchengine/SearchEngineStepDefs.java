package com.stepdefs.searchengine;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.Products;
import qa.pages.SearchEngine;

import static qa.driver.Driver.*;

public class SearchEngineStepDefs {

    private SearchEngine searchEngine;
    private Products products;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        searchEngine = new SearchEngine(getDriver());
        products = new Products(getDriver());
    }

    @When("The user clicks on the search engine field")
    public void theUserClicksOnTheSearchEngineField() throws InterruptedException {

        searchEngine.clickOnTheSearchField();

        Thread.sleep(2000);
    }

    @And("Enters the '{string}' phrase")
    public void entersThePhrase(String phrase) {

        searchEngine.enterPhrase(phrase);
    }

    @And("Submits")
    public void submits() throws InterruptedException {

        searchEngine.submit();

        Thread.sleep(2000);
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

    @And("The number of products is {int}")
    public void theNumberOfProductsIs(int numberOfProducts) {

        Assert.assertEquals(products.getProductsColumnsSize(), numberOfProducts);
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
