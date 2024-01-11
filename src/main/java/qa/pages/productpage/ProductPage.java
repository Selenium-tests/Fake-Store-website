package qa.pages.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.tobyclass.ByFinder;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
    }

    @FindBy(xpath = ".//h1[@class='product_title entry-title']")
    WebElement productTitle;

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement price;

    @FindBy(xpath = ".//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    WebElement message;

    public String getProductTitle() {

        return productTitle.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        getInteractions().click(addToCartButton, PerformType.JS_EXECUTOR);
    }

    public void waitForMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(message)));
    }
}
