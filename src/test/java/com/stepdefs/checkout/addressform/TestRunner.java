package com.stepdefs.checkout.addressform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/addressForm.feature",
        plugin = { "pretty", "html:target/cucumber-reports/addressForm.html" },
        glue = { "com.stepdefs.checkout.addressform",
                 "com.stepdefs.checkout.creditcardnumber",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class TestRunner {
}
