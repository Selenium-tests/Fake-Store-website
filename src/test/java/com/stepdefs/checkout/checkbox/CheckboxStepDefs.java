package com.stepdefs.checkout.checkbox;

import com.testutil.TestUtil;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.addressform.AddressForm;

public class CheckboxStepDefs {

    private final TestUtil testUtil;

    public CheckboxStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Then("A message about not accepting the terms was displayed")
    public void messageAboutNotAcceptingTermsHasBeenDisplayed() {

        AddressForm addressForm = new AddressForm(testUtil.getDriver(), "billing");

        Assert.assertTrue(addressForm.isErrorMessageDisplayed());
    }
}
