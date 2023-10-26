package com.stepdefs.checkout;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/checkout.feature",
        plugin = { "pretty", "html:target/cucumber-reports/checkout.html" },
        glue = {"com.stepdefs.checkout", "com.commonstepdefs", "com.testutil"}
)
public class Runner {
}
