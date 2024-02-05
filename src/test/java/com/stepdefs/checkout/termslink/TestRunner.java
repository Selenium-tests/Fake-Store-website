package com.stepdefs.checkout.termslink;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/termsLink.feature",
        plugin = { "pretty", "html:target/cucumber-reports/termsLink.html" },
        glue = { "com.stepdefs.checkout.termslink",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class TestRunner {
}
