package com.stepdefs.shoppingcart.productquantityfield;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/shoppingCart/productQuantityField.feature",
        plugin = { "pretty", "html:target/cucumber-reports/productQuantityField.html" },
        glue = { "com.stepdefs.shoppingcart.productquantityfield",
                 "com.stepdefs.shoppingcart.functionalities",
                 "com.commonstepdefs",
                 "com.testutil" }
)
public class Runner {
}
