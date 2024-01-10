package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.pages.loginform.LoginForm;
import qa.testutil.TestUtil;

public class LoginCommonSteps {

    private final TestUtil testUtil;

    public LoginCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("The user is logged in with email: {string} and password: {string}")
    public void userIsLoggedIn(String email, String password) throws IllegalAccessException {

        testUtil.goToUrl("https://fakestore.testelka.pl/moje-konto/");

        LoginForm loginForm = new LoginForm(testUtil.getDriver());
        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @And("The address editing section is open")
    public void theAddressEditingSectionIsOpen() throws IllegalAccessException {

        testUtil.goToUrl("https://fakestore.testelka.pl/moje-konto/edytuj-adres/");
    }
}
