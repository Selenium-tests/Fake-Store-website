package com.stepdefs.shoppingcart.removingproducts;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/shoppingCart/removingProducts.feature",
        plugin = { "pretty", "html:target/cucumber-reports/removeButton.html" },
        glue = {"com.stepdefs.shoppingcart.removingproducts",
                "com.commonstepdefs",
                "qa.testutil" },
        tags = "@SCCRemovingWithQuantityField"
)
public class TestRunner {
}
