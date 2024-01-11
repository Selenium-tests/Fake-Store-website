package com.stepdefs.shoppingcart.addingfromproductpage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/shoppingCart/addingFromProductPage.feature",
        plugin = {"pretty", "html:target/cucumber-reports/addingProductToTheCart.html"},
        glue = { "com.stepdefs.shoppingcart.addingfromproductpage",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class TestRunner {
}
