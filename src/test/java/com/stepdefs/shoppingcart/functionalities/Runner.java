package com.stepdefs.shoppingcart.functionalities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/shoppingCart/shoppingCartFunctionalities.feature",
        plugin = { "pretty", "html:target/cucumber-reports/search-engine.html" },
        glue = {"com.stepdefs.shoppingcart.functionalities", "com.commonstepdefs", "com.testutil"}
)
public class Runner {
}
