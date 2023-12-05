package com.commonstepdefs;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.testutil.TestUtil;

public class PageUrlCommonSteps {

    private final TestUtil testUtil;

    public PageUrlCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Then("The page with url {string} has been opened")
    public void thePageWithUrlHasBeenOpened(String url) {

        Assert.assertEquals(testUtil.getDriver().getCurrentUrl(), url);
    }
}
