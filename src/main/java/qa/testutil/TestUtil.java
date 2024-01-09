package qa.testutil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import qa.browserrunner.BrowserRunner;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;

public class TestUtil {

    private WebDriver driver;

    @Before
    public void setUp() {

        driver = WebDriverProvider.getFactory(Browser.CHROME).createDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        BrowserRunner.quit(driver);
    }

    public void goToUrl(String url) {

        driver.get(url);
    }

    public WebDriver getDriver() {

        return driver;
    }
}
