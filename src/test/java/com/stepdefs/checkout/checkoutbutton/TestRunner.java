package com.stepdefs.checkout.checkoutbutton;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/openingCheckoutPage.feature",
        plugin = { "pretty", "html:target/cucumber-reports/creditCardNumber.html" },
        glue = { "com.stepdefs.checkout.checkoutbutton",
                "com.commonstepdefs",
                "qa.testutil" }
)
public class TestRunner {
}
