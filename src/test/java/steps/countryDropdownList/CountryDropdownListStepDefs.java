package steps.countryDropdownList;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.*;
import qa.pages.addressform.AddressForm;

import static qa.driver.Driver.*;

public class CountryDropdownListStepDefs {

    private AddressForm addressForm;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        addressForm = new AddressForm(getDriver(), "billing");
    }

    @Given("An user is logged in with email: {string} and password: {string}")
    public void anUserIsLoggedIn(String email, String password) {

        MainMenu mainMenu = new MainMenu(getDriver());
        LoginForm loginForm = new LoginForm(getDriver());

        mainMenu.hideNotice();
        mainMenu.click("Moje konto");

        loginForm.setUsername(email);
        loginForm.setPassword(password);
        loginForm.clickSubmitButton();
    }

    @When("Goes to the \"Adres rozliczeniowy\" form")
    public void goesToTheAddressForm() {

        Account account = new Account(getDriver());
        account.clickLink("Adres");
        account.getAddresses().clickAddButton(0);
    }

    @When("An user clicks the country drop-down list arrow")
    public void anUserClicksTheDropdownListArrow() {

        addressForm.getCountryDropdownList().clickArrow();
    }

    @And("Types {string} in the drop-down search field")
    public void typesCountryInTheDropdownListSearchField(String country) {

        addressForm.getCountryDropdownList().setCountry(country);
    }

    @And("Other {string}")
    public void other(String name) {

        addressForm.setFirstName(name);
    }

    @Then("The message about incorrect country name is not displayed")
    public void messageIsNotDisplayed() {

        Assert.assertFalse(addressForm.getCountryDropdownList().isMessageDisplayed());
    }

    @Then("The message about incorrect country name is displayed")
    public void messageIsDisplayed() {

        Assert.assertTrue(addressForm.getCountryDropdownList().isMessageDisplayed());
    }

    @After
    public void tearDown() {

        quitDriver();
    }
}
