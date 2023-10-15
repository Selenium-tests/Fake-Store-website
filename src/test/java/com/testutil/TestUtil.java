package com.testutil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import qa.driver.Driver;
import qa.enums.Browser;

public class TestUtil {

    @Before
    public void init() {

        Driver.createDriver(Browser.CHROME);
        Driver.startDriver();
    }

    public WebDriver getDriver() {

        return Driver.getDriver();
    }

    @After
    public void tearDown() {

        Driver.quitDriver();
    }
}
