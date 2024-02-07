package qa.pages.quantityfield;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;

public class QuantityField extends BasePage {

    private final WebElement field;

    public QuantityField(WebDriver driver, WebElement field) {

        super(driver);

        this.field = field;
    }

    public void setQuantity(String quantity) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(field)));
        getInteractions().fill(field, PerformType.JS_EXECUTOR, quantity);
    }

    public String getValue() {

        return field.getAttribute("value");
    }
}
