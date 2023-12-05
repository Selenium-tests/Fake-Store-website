package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory extends WebDriverFactory {

    public WebDriver createDriver() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.merge(getCapabilities(EdgeOptions.CAPABILITY, options));
        setProperty("edgedriver.exe", "webdriver.edge.driver");

        return new EdgeDriver(options);
    }
}
