package qa.browserrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserRunner {

    private static final String url = "https://fakestore.testelka.pl/";

    public static void run(WebDriver driver) {

        System.out.println("Opening the page: \"" + url + "\" on the " +
                            ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + " " +
                            ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());

        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void quit(WebDriver driver) {

        System.out.println("Closing the browser");

        driver.quit();
    }
}
