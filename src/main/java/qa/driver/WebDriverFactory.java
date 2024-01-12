package qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.enums.Browser;

public abstract class WebDriverFactory {

    protected void setup(Browser browser) {

        switch (browser) {

            case CHROME -> WebDriverManager.chromedriver().setup();
            case FIREFOX -> WebDriverManager.firefoxdriver().setup();
            case EDGE -> WebDriverManager.edgedriver();
        }
    }

    protected DesiredCapabilities getCapabilities(String key, Object value) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(key, value);

        return capabilities;
    }

    protected void setProperty(String key, String value) {

        System.setProperty(key, value);
    }

    public abstract WebDriver createDriver();
}
