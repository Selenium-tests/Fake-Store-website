package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.merge(getCapabilities(ChromeOptions.CAPABILITY, options));
        setProperty("chromedriver.exe", "webdriver.chrome.driver");

        return new ChromeDriver(options);
    }
}
