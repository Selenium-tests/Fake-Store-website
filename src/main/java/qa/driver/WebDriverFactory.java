package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class WebDriverFactory {

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
