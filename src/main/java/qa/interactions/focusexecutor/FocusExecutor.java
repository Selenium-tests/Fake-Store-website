package qa.interactions.focusexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FocusExecutor {

    private JavascriptExecutor executor;

    public FocusExecutor(WebDriver driver) {

        executor = (JavascriptExecutor) driver;
    }

    public void setFocus(WebElement element) {

        executor.executeScript("arguments[0].focus();", element);
    }
}
