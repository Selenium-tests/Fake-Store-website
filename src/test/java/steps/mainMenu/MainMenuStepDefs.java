package steps.mainMenu;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.enums.Browser;
import qa.pages.MainMenu;
import static qa.driver.Driver.createDriver;
import static qa.driver.Driver.startDriver;
import static qa.driver.Driver.getDriver;
import static qa.driver.Driver.quitDriver;


public class MainMenuStepDefs {

    MainMenu mainMenu;


    @Before
    public void init() {

        createDriver(Browser.CHROME);
        startDriver();
    }

    @Given("The user is on the home page")
    public void theUserIsOnTheHomePage() {

        mainMenu = new MainMenu(getDriver());
    }

    @When("The user clicks {string} link")
    public void theUserClicksLink(String linkText) {

        mainMenu.click(linkText);
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
