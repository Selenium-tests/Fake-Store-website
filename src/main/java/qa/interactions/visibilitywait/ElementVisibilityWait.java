package qa.interactions.visibilitywait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.tobyclass.ByFinder;

import java.time.Duration;

public class ElementVisibilityWait {

    private WebDriverWait wait;

    public ElementVisibilityWait(WebDriver driver) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void untilElementIsVisible(WebElement element) throws IllegalAccessException {

        By byFromWebElement = ByFinder.getByFromWebElement(element);

        wait.until(ExpectedConditions.visibilityOfElementLocated(byFromWebElement));
    }
}
