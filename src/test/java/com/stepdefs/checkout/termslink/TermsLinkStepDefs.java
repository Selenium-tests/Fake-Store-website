package com.stepdefs.checkout.termslink;

import io.cucumber.java.en.When;
import qa.testutil.TestUtil;
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

    @When("The user clicks the \"regulamin\" link")
    public void clicksTheTermsLink() {

        checkoutPage.clickTermsLink();
    }

    @Then("Information about the regulations has been displayed")
    public void termsAndConditionsHaveBeenDisplayed() {

        try {
            checkoutPage.waitForTermsAndConditionsLocator();
        } catch (Exception e) {
            Assert.fail("The terms and conditions text is not visible");
        }
    }
}
