package qa.browserrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserRunner {

    private static final Logger logger = LoggerFactory.getLogger(BrowserRunner.class);
    private static final String url = "https://fakestore.testelka.pl/";

    public static void run(WebDriver driver) {

        logger.info("Opening the page: \"" + url + "\" on the " +
                ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + " " +
                ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());

        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void quit(WebDriver driver) {

        logger.info("Closing the browser");

        driver.quit();
    }
}
