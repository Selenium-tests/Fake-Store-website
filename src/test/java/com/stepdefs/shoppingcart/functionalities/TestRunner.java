package com.stepdefs.shoppingcart.functionalities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/shoppingCart/removeButton.feature",
        plugin = { "pretty", "html:target/cucumber-reports/removeButton.html" },
        glue = {"com.stepdefs.shoppingcart.functionalities",
                "com.commonstepdefs",
                "qa.testutil" }
)
public class TestRunner {
}
