package qa.base;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.interactions.Interactions;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    @Getter
    private final WebDriverWait webDriverWait;
    private final Interactions interactions;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
        interactions = new Interactions(driver);
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected Interactions getInteractions() {

        return interactions;
    }
}
