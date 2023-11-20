package com.stepdefs.checkout.termslink;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.checkout.CheckoutPage;

public class TermsLinkStepDefs {

    private final TestUtil testUtil;
    private final CheckoutPage checkoutPage;

    public TermsLinkStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
        checkoutPage = new CheckoutPage(testUtil.getDriver());
    }

    @And("Clicks the \"regulamin\" link")
    public void clicksTheTermsLink() throws IllegalAccessException {

        checkoutPage.clickTermsLink();
    }

    @Then("Information about the regulations has been displayed")
    public void termsAndConditionsHaveBeenDisplayed() {

        Assert.assertTrue(checkoutPage.isTermsAndConditionsTextBoxVisible());
    }
}
