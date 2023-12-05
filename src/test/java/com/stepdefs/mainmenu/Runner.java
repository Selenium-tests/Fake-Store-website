package com.stepdefs.mainmenu;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/features/mainMenu/mainMenu.feature",
        plugin = { "pretty", "html:target/cucumber-reports/mainMenu.html" },
        glue = { "com.stepdefs.mainmenu",
                 "com.commonstepdefs",
                 "qa.testutil" }
)
public class Runner {
}
