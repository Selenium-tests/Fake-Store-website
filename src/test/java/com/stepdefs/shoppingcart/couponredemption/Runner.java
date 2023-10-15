package com.stepdefs.shoppingcart.couponredemption;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/shoppingCart/couponRedemption.feature",
        plugin = { "pretty", "html:target/cucumber-reports/couponRedemption.html" },
        glue = {"com.stepdefs.shoppingcart.couponredemption", "com.commonstepdefs"},
        tags = "@CC250Reusing"
)
public class Runner {
}
