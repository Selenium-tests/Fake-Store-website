package com.stepdefs.account.accountpagenavigation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"./src/main/resources/features/account/accountPageNavigation.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/accountPageNavigation.html"},
        glue = { "com.stepdefs.account.accountpagenavigation",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
