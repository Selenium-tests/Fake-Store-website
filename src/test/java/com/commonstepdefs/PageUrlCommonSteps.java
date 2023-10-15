package com.commonstepdefs;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import static qa.driver.Driver.getDriver;

public class PageUrlCommonSteps {

    @Then("The page with url {string} has been opened")
    public void thePageWithUrlHasBeenOpened(String url) {

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
