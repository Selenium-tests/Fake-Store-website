package qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public String getUrl() {

        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {

        return driver;
    }
}
