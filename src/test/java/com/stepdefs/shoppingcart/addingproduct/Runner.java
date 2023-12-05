package com.stepdefs.shoppingcart.addingproduct;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/shoppingCart/addingProduct.feature",
        plugin = {"pretty", "html:target/cucumber-reports/addingProductToTheCart.html"},
        glue = { "com.stepdefs.shoppingcart.addingproduct",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
