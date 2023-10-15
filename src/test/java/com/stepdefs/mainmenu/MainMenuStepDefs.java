package com.stepdefs.mainmenu;

import com.testutil.TestUtil;
import io.cucumber.java.en.When;
import qa.pages.MainMenu;


public class MainMenuStepDefs {

    private final TestUtil testUtil;

    public MainMenuStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @When("The user clicks {string} link")
    public void theUserClicksLink(String linkText) {

        MainMenu mainMenu = new MainMenu(testUtil.getDriver());
        mainMenu.click(linkText);
    }
}
