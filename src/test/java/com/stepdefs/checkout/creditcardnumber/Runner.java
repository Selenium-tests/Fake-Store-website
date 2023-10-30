package com.stepdefs.checkout.creditcardnumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/checkout/creditCardNumber.feature",
        plugin = { "pretty", "html:target/cucumber-reports/creditCardNumber.html" },
        glue = { "com.stepdefs.checkout.creditcardnumber", "com.commonstepdefs", "com.testutil" }
)
public class Runner {
}
