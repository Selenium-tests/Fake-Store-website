package qa.interactions.formfillable;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FillWithActions extends FormFillable {

    private final Actions actions;

    public FillWithActions(WebDriver driver) {

        super(driver);

        actions = new Actions(driver);
    }

    @Override
    public void fill(WebElement element, String text) throws IllegalAccessException {

        visibilityWait.untilElementIsVisible(element);

        try {

            focusExecutor.setFocus(element);
            actions.moveToElement(element).click().perform();
            actions.sendKeys(text).perform();

        } catch (StaleElementReferenceException e) {

            visibilityWait.untilElementIsVisible(element);

            focusExecutor.setFocus(element);
            actions.moveToElement(element).sendKeys(text).perform();
        }
    }
}
