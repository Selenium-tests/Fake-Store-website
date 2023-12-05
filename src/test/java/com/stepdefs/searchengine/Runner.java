package com.stepdefs.searchengine;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/searchEngine/searchEngine.feature",
        plugin = { "pretty", "html:target/cucumber-reports/searchEngine.html" },
        glue = { "com.stepdefs.searchengine",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
