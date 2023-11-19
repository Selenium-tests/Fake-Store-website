package qa.interactions.clickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.interactions.visibilitywait.ElementVisibilityWait;

public abstract class Clickable {
    protected ElementVisibilityWait visibilityWait;

    public Clickable(WebDriver driver) {

        visibilityWait = new ElementVisibilityWait(driver);
    }

    abstract public void click(WebElement element) throws IllegalAccessException;
}
