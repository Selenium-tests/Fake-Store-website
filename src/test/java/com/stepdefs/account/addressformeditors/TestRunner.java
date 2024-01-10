package com.stepdefs.account.addressformeditors;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/account/linksToAddressFormEditors.feature",
        plugin = {"pretty", "html:target/cucumber-reports/linksToAddressFormEditors.html" },
        glue = { "com.stepdefs.account.addressformeditors",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class TestRunner {
}
