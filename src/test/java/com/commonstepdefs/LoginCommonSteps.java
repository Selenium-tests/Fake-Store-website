package com.commonstepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.enums.URLs;
import qa.pages.loginform.LoginForm;
import qa.testutil.TestUtil;

public class LoginCommonSteps {

    private final TestUtil testUtil;

    public LoginCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("The user is logged in with email: {string} and password: {string}")
    public void userIsLoggedIn(String email, String password) throws IllegalAccessException {

        testUtil.goToUrl(URLs.LOGIN_PAGE.getName());

        LoginForm loginForm = new LoginForm(testUtil.getDriver());
        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @And("The address editing section is open")
    public void theAddressEditingSectionIsOpen() {

        testUtil.goToUrl(URLs.ADDRESS_EDITING_SECTION.getName());
    }
}
