package qa.pages.animation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.tobyclass.ByFinder;

public class Animation extends BasePage {


    public Animation(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".woocommerce-cart-form.processing")
    WebElement cartFormProcessing;

    public void waitUntilIsInvisible() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(ByFinder.getByFromWebElement(cartFormProcessing)));
    }
}
