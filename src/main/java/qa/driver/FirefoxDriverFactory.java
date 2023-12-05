package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory extends WebDriverFactory {

    public WebDriver createDriver() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        options.merge(getCapabilities(FirefoxOptions.FIREFOX_OPTIONS, options));
        setProperty("geckodriver.exe", "webdriver.gecko.driver");

        return new FirefoxDriver(options);
    }
}
