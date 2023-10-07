package steps.addressForms;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import qa.enums.Browser;
import qa.pages.Account;
import qa.pages.addressform.AddressForm;
import qa.pages.LoginForm;
import qa.pages.MainMenu;

import static qa.driver.Driver.*;
public class AddressFormsStepDefs {

    private AddressForm addressForm;

    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
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

    @When("An user goes to the {string} form")
    public void thePageIsOpen(String column) {

        int index = column.equals("Adres rozliczeniowy") ? 0 : 1;
        String prefix = column.equals("Adres rozliczeniowy") ? "billing" : "shipping";

        Account account = new Account(getDriver());
        account.clickLink("Adres");
        account.getAddresses().clickAddButton(index);

        addressForm = new AddressForm(getDriver(), prefix);
    }

    @And("Types {string} as first name")
    public void anUserTypesFirstName(String firstName) {

        addressForm.setFirstName(firstName);
    }

    @And("Types {string} as last name")
    public void anUserTypesLastName(String lastName) {

        addressForm.setLastName(lastName);
    }

    @And("Types {string} as a company")
    public void anUserTypesCompany(String company) {

        addressForm.setCompany(company);
    }

    @And("Types {string} as an address")
    public void anUserTypesStreet(String address) {

        addressForm.setAddress1(address);
    }

    @And("Types {string} as a postcode")
    public void anUserTypesPostcode(String postcode) {

        addressForm.setPostcode(postcode);
    }

    @And("Types {string} as a city")
    public void anUserTypesCity(String city) {

        addressForm.setCity(city);
    }

    @And("Types {string} as a phone number")
    public void anUserTypesPhoneNumber(String phoneNumber) {

        addressForm.setPhone(phoneNumber);
    }

    @And("Types {string} as a email")
    public void anUserTypesEmail(String email) {

        addressForm.setEmail(email);
    }
}
