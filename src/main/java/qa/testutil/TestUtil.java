package qa.testutil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;

import java.time.Duration;

public class TestUtil {

    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(TestUtil.class);

    @Before
    public void setUp() {

        logger.info("Initializing WebDriver...");

        driver = WebDriverProvider.getFactory(Browser.CHROME).createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        logger.info("Quit");
        driver.quit();
    }

    public void goToUrl(String url) {

        driver.get(url);
    }

    public WebDriver getDriver() {

        return driver;
    }
}
