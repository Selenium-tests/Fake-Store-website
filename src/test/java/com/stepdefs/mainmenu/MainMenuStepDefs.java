package com.stepdefs.mainmenu;

import qa.testutil.TestUtil;
import io.cucumber.java.en.When;
import qa.pages.mainmenu.MainMenu;


public class MainMenuStepDefs {

    private final TestUtil testUtil;

    public MainMenuStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks the {string} link")
    public void theUserClicksTheLink(String linkText) throws IllegalAccessException {

        MainMenu mainMenu = new MainMenu(testUtil.getDriver());
        mainMenu.click(linkText);
    }
}
