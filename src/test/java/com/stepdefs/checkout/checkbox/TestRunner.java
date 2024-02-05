package com.stepdefs.checkout.checkbox;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/checkbox.feature",
        plugin = { "pretty", "html:target/cucumber-reports/checkbox.html" },
        glue = { "com.stepdefs.checkout.checkbox",
                 "com.stepdefs.checkout.creditcardnumber",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class TestRunner {
}
