package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.LoginForm;
import qa.pages.MainMenu;
import qa.pages.account.Account;

import static qa.driver.Driver.*;

public class LoginCommonSteps {

    @Given("An user is logged in with email: {string} and password: {string}")
    public void anUserIsLoggedIn(String email, String password) {

        MainMenu mainMenu = new MainMenu(getDriver());
        LoginForm loginForm = new LoginForm(getDriver());

        mainMenu.click("Moje konto");
        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @And("The address editing section is open")
    public void theAddressEditingSectionIsOpen() {

        Account account = new Account(getDriver());
        account.clickLink("Adres");
    }
}
