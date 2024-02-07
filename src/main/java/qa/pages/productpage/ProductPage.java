package qa.pages.productpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.pages.quantityfield.QuantityField;
import qa.tobyclass.ByFinder;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "h1[class='product_title entry-title']")
    WebElement productName;

    @FindBy(className = "price")
    WebElement price;

    @FindBy(xpath = ".//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    WebElement message;

    public String getProductName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public QuantityField getQuantityField() {

        return new QuantityField(getDriver(), getDriver().findElement(By.name("quantity")));
    }

    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        getInteractions().click(addToCartButton, PerformType.JS_EXECUTOR);
    }

    public void waitForMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(message)));
    }
}
