package com.stepdefs.account.fillingaddressform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/account/fillingAddressForm.feature",
        plugin = { "pretty", "html:target/cucumber-reports/fillingAddressForm.html" },
        glue = {"com.stepdefs.account.fillingaddressform", "com.commonstepdefs", "qa.testutil"},
        tags = "@AFIncorrectFName"
)
public class Runner {
}
