package com.stepdefs.searchengine;

import org.testng.asserts.SoftAssert;
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
    private final SoftAssert softAssert;

    public SearchEngineStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        searchEngine = new SearchEngine(testUtil.getDriver());
        resultsPage = new ResultsPage(testUtil.getDriver());
        softAssert = new SoftAssert();
    }


    @When("The user clicks on the search engine field")
    public void theUserClicksOnTheSearchEngineField() throws IllegalAccessException {

        searchEngine.clickOnTheSearchField();
    }

    @And("Enters the '{string}' phrase")
    public void entersThePhrase(String phrase) throws IllegalAccessException {

        searchEngine.enterPhrase(phrase);
    }

    @And("Submits")
    public void submits() {

        searchEngine.submit();
    }

    @Then("The placeholder disappears")
    public void thePlaceholderDisappears() {

        Assert.assertEquals(searchEngine.getPlaceholderText(), "");
    }

    @Then("Products have been found")
    public void productsHaveBeenFound() {

        Assert.assertTrue(resultsPage.hasColumns(),
                "Products have not been found");

        resultsPage.findProducts();

        Assert.assertTrue(resultsPage.getProductsColumnsSize() > 0,
                "Products have not been found");
    }

    @Then("Products have not been found")
    public void productsHaveNotBeenFound() {

        Assert.assertFalse(resultsPage.hasColumns(),
                "Products have been found");
    }

    @And("Product names contain the phrase {string}")
    public void productNamesContainThePhrase(String phrase) {

        resultsPage.getProductsTitles().forEach(
                i -> softAssert.assertTrue(i.toLowerCase().contains(phrase.toLowerCase()))
        );

        softAssert.assertAll();
    }

    @And("The number of products is {int}")
    public void theNumberOfProductsIs(int numberOfProducts) {

        Assert.assertEquals(resultsPage.getProductsColumnsSize(), numberOfProducts);
    }
}
