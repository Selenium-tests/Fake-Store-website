package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import qa.enums.Browser;

public class EdgeDriverFactory extends WebDriverFactory {

    public WebDriver createDriver() {

        setup(Browser.EDGE);

        EdgeOptions options = new EdgeOptions();
        options.merge(getCapabilities(EdgeOptions.CAPABILITY, options));

        return new EdgeDriver(options);
    }
}
