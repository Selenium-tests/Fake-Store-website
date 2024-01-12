package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import qa.enums.Browser;

import java.util.Arrays;
import java.util.List;

public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createDriver() {

        setup(Browser.CHROME);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.merge(getCapabilities(ChromeOptions.CAPABILITY, options));

        return new ChromeDriver(options);
    }
}
