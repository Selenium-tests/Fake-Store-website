package qa.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import qa.enums.PerformType;

public class Interactions {

    private final JavascriptExecutor javascriptExecutor;
    private final Actions actions;

    public Interactions(WebDriver driver) {

        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void click(WebElement element, PerformType type) {

        switch (type) {

            case CLASS_METHOD -> { element.click(); }
            case JS_EXECUTOR -> { javascriptExecutor.executeScript("arguments[0].click()", element); }
            case ACTIONS -> { actions.moveToElement(element).click().perform(); }
        }
    }

    public void fill(WebElement element, PerformType type, CharSequence... keys) {

        switch (type) {

            case CLASS_METHOD -> { element.sendKeys(keys); }
            case JS_EXECUTOR -> { javascriptExecutor.executeScript("arguments[0].value = arguments[1];", element, keys); }
            case ACTIONS -> { actions.moveToElement(element).click().perform(); actions.sendKeys(keys).perform(); }
        }
    }

    public void scrollIntoView(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void focus(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].focus();", element);
    }
}
