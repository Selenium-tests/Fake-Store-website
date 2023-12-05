package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.LoginForm;
import qa.pages.MainMenu;
import qa.pages.account.Account;
import qa.testutil.TestUtil;

public class LoginCommonSteps {

    private final TestUtil testUtil;

    public LoginCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("An user is logged in with email: {string} and password: {string}")
    public void anUserIsLoggedIn(String email, String password) throws IllegalAccessException {

        MainMenu mainMenu = new MainMenu(testUtil.getDriver());
        LoginForm loginForm = new LoginForm(testUtil.getDriver());

        mainMenu.click("Moje konto");
        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @And("The address editing section is open")
    public void theAddressEditingSectionIsOpen() throws IllegalAccessException {

        Account account = new Account(testUtil.getDriver());
        account.clickLink("Adres");
    }
}
