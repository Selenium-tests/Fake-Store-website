package com.stepdefs.checkout.expirationdate;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/expirationDate.feature",
        plugin = { "pretty", "html:target/cucumber-reports/expirationDate.html" },
        glue = { "com.stepdefs.checkout.creditcardnumber",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
