package qa.interactions.formfillable;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillWithSendKeysMethod extends FormFillable {

    public FillWithSendKeysMethod(WebDriver driver) {

        super(driver);
    }

    @Override
    public void fill(WebElement element, String text) throws IllegalAccessException {

        visibilityWait.untilElementIsVisible(element);

        try {

            focusExecutor.setFocus(element);
            element.sendKeys(text);

        } catch (StaleElementReferenceException e) {

            visibilityWait.untilElementIsVisible(element);

            focusExecutor.setFocus(element);
            element.sendKeys(text);
        }
    }
}
