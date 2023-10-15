package com.stepdefs.mainmenu;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import qa.enums.Browser;
import qa.pages.MainMenu;
import static qa.driver.Driver.createDriver;
import static qa.driver.Driver.startDriver;
import static qa.driver.Driver.getDriver;
import static qa.driver.Driver.quitDriver;


public class MainMenuStepDefs {

    MainMenu mainMenu;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        mainMenu = new MainMenu(getDriver());
    }

    @When("The user clicks {string} link")
    public void theUserClicksLink(String linkText) {

        mainMenu.click(linkText);
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
