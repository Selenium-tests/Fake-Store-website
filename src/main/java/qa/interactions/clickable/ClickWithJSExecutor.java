package qa.interactions.clickable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickWithJSExecutor extends Clickable {

    private JavascriptExecutor executor;

    public ClickWithJSExecutor(WebDriver driver) {

        super(driver);

        executor = (JavascriptExecutor) driver;
    }

    @Override
    public void click(WebElement element) throws IllegalAccessException {

        visibilityWait.untilElementIsVisible(element);
        executor.executeScript("arguments[0].click();", element);
    }
}
