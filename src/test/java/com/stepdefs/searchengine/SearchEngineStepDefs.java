package com.stepdefs.searchengine;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.Products;
import qa.pages.SearchEngine;

public class SearchEngineStepDefs {

    private final TestUtil testUtil;
    private final SearchEngine searchEngine;
    private final Products products;

    public SearchEngineStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        searchEngine = new SearchEngine(testUtil.getDriver());
        products = new Products(testUtil.getDriver());
    }


    @When("The user clicks on the search engine field")
    public void theUserClicksOnTheSearchEngineField() throws InterruptedException, IllegalAccessException {

        searchEngine.clickOnTheSearchField();

        Thread.sleep(2000);
    }

    @And("Enters the '{string}' phrase")
    public void entersThePhrase(String phrase) throws IllegalAccessException {

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
}
