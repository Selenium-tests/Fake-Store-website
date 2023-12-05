package com.stepdefs.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/login/login.feature",
        plugin = { "pretty", "html:target/cucumber-reports/login.html" },
        glue = { "com.stepdefs.login",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
