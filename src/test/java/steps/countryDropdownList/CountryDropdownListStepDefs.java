package steps.countryDropdownList;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.*;
import qa.pages.addressform.AddressForm;
import qa.pages.addressform.CountryDropdownList;

import static qa.driver.Driver.*;

public class CountryDropdownListStepDefs {

    AddressForm addressForm;
    CountryDropdownList countryDropdownList;
    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();

        addressForm = new AddressForm(getDriver(), "shipping");
        countryDropdownList = new CountryDropdownList(getDriver());
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

    @And("The {string} page is open")
    public void thePageIsOpen(String column) {

        int index = column.equals("Adres rozliczeniowy") ? 0 : 1;

        Account account = new Account(getDriver());
        account.clickLink("Adres");
        account.getAddresses().clickAddButton(index);
    }

    @When("An user clicks the drop-down list arrow")
    public void anUserClicksTheDropdownListButton() throws InterruptedException {

        countryDropdownList.clickArrow();
    }

    @And("Types {string} in the drop-down search field")
    public void typesCountryInTheDropdownListSearchField(String country) {

        addressForm.getCountryDropdownList().setCountry(country);
    }

    @Then("The message about incorrect country name is not displayed")
    public void messageIsNotDisplayed() {

        Assert.assertTrue(addressForm.getCountryDropdownList().isMessageDisplayed());
    }
}
