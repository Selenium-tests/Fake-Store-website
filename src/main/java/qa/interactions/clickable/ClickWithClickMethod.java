package qa.interactions.clickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickWithClickMethod extends Clickable {


    public ClickWithClickMethod(WebDriver driver) {

        super(driver);
    }

    @Override
    public void click(WebElement element) throws IllegalAccessException {

        visibilityWait.untilElementIsVisible(element);
        element.click();
    }
}
