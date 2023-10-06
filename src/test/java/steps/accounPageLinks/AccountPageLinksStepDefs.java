package steps.accounPageLinks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.Account;
import qa.pages.LoginForm;
import qa.pages.MainMenu;

import static qa.driver.Driver.*;

public class AccountPageLinksStepDefs {

    Account account;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        account = new Account(getDriver());
    }

    @Given("An user is logged in with email: {string} and password: {string}")
    public void anUserIsLoggedIn(String email, String password) {

        MainMenu mainMenu = new MainMenu(getDriver());
        LoginForm loginForm = new LoginForm(getDriver());

        mainMenu.click("Moje konto");
        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @When("An user clicks the {string} link")
    public void anUserClicksTheLink(String link) {

        account.clickLink(link);
    }

    @Then("The page with url {string} has been opened")
    public void thePageWithUrlHasBeenOpened(String url) {

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Then("An user is logged out")
    public void anUserIsLoggedOut() {

        Assert.assertFalse(account.areNavigationButtonsVisible());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
