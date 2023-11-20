package qa.interactions.clickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickWithActions extends Clickable {

    private Actions actions;

    public ClickWithActions(WebDriver driver) {

        super(driver);

        actions = new Actions(driver);
    }

    @Override
    public void click(WebElement element) throws IllegalAccessException {

        visibilityWait.untilElementIsVisible(element);
        actions.moveToElement(element).click().perform();
    }
}
