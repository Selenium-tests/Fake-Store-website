package com.stepdefs.account.countrydropdownlist;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/features/account/countryDropdownList.feature",
        plugin = {"pretty", "html:target/cucumber-reports/countryDropdownList.html"},
        glue = {"com.stepdefs.account.countrydropdownlist", "com.commonstepdefs"},
        tags = "@CDLCorrectCityName"
)
public class Runner {
}
