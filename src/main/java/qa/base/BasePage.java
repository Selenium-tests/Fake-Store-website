package qa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.interactions.Interactions;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;
    private final Interactions interactions;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(this.driver, this);
        interactions = new Interactions(driver);
    }

    public WebDriverWait getWebDriverWait() {

        return webDriverWait;
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected Interactions getInteractions() {

        return interactions;
    }
}
