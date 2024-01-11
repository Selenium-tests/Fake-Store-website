package com.stepdefs.shoppingcart.addingfromthumbnail;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/shoppingCart/addingFromProductThumbnail.feature",
        plugin = {"pretty", "html:target/cucumber-reports/addingProductToTheCart.html"},
        glue = { "com.stepdefs.shoppingcart.addingfromthumbnail",
                "com.commonstepdefs",
                "qa.testutil" },
        tags = "@APTClickingButton"
)
public class TestRunner {
}
