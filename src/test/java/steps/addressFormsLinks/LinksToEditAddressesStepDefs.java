package steps.addressFormsLinks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.Account;
import qa.pages.LoginForm;
import qa.pages.MainMenu;

import static qa.driver.Driver.*;

public class LinksToEditAddressesStepDefs {

    private Account account;

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

    @And("The address editing section is open")
    public void theAddressEditingSectionIsOpen() {

        account.clickLink("Adres");
    }

    @When("An user clicks the symbol in the {string} column")
    public void anUserClicksTheButton(String column) {

        int index = column.equals("Adres rozliczeniowy") ? 0 : 1;

        account.getAddresses().clickAddButton(index);
    }

    @Then("The page with url {string} has been opened")
    public void thePageWithUrlHasBeenOpened(String url) {

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
