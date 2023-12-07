package com.stepdefs.searchengine;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.searchengine.ResultsPage;
import qa.pages.searchengine.SearchEngine;

public class SearchEngineStepDefs {

    private final TestUtil testUtil;
    private final SearchEngine searchEngine;
    private final ResultsPage resultsPage;

    public SearchEngineStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        searchEngine = new SearchEngine(testUtil.getDriver());
        resultsPage = new ResultsPage(testUtil.getDriver());
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

        Assert.assertFalse(resultsPage.isResultCountEmpty());
    }

    @Then("The products count text is not present")
    public void theProductsCountTextIsNotPresent() {

        Assert.assertTrue(resultsPage.isResultCountEmpty());
    }

    @And("The number of products is {int}")
    public void theNumberOfProductsIs(int numberOfProducts) {

        Assert.assertEquals(resultsPage.getProductsColumnsSize(), numberOfProducts);
    }
}
