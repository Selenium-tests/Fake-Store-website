package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import qa.enums.Browser;

public class FirefoxDriverFactory extends WebDriverFactory {

    public WebDriver createDriver() {

        setup(Browser.FIREFOX);

        FirefoxOptions options = new FirefoxOptions();
        options.merge(getCapabilities(FirefoxOptions.FIREFOX_OPTIONS, options));

        return new FirefoxDriver(options);
    }
}
