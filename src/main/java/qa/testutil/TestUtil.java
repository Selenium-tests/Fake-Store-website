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
    public void init() {

        driver = WebDriverProvider.getFactory(Browser.CHROME).createDriver();
        BrowserRunner.run(driver);
    }

    public WebDriver getDriver() {

        return driver;
    }

    @After
    public void tearDown() {

        BrowserRunner.quit(driver);
    }
}
