package qa.interactions.formfillable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.interactions.focusexecutor.FocusExecutor;
import qa.interactions.visibilitywait.ElementVisibilityWait;

public abstract class FormFillable {

    protected ElementVisibilityWait visibilityWait;
    protected FocusExecutor focusExecutor;

    public FormFillable(WebDriver driver) {

        visibilityWait = new ElementVisibilityWait(driver);
        focusExecutor = new FocusExecutor(driver);
    }

    public abstract void fill(WebElement element, String text) throws IllegalAccessException;
    public abstract void fill(WebElement element, Keys keys) throws IllegalAccessException;
}
