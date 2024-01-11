package qa.pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;

public class Row extends BasePage {

    private WebElement removeButton;
    private WebElement productName;
    private WebElement quantityField;
    private WebElement price;
    private WebElement totalPrice;

    public Row(WebDriver driver) {

        super(driver);
    }

    public void setRow(WebElement product) {

        removeButton = product.findElement(By.xpath(".//a[@class='remove']"));
        productName = product.findElement(By.className("product-name"));
        quantityField = product.findElement(By.cssSelector("input[class='input-text qty text']"));
        price = product.findElement(By.cssSelector("span[class='woocommerce-Price-amount amount']"));
        totalPrice = product.findElement(By.className("product-subtotal"));
    }

    public void clickRemoveButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(removeButton));
        getInteractions().click(removeButton, PerformType.JS_EXECUTOR);
    }

    public String getName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void setQuantity(String quantity) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(quantityField)));
        getInteractions().fill(quantityField, PerformType.CLASS_METHOD, quantity);
    }

    public String getTotalPrice() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(totalPrice)),
                ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(totalPrice)))
        ));

        return totalPrice.getText();
    }

    public boolean isValidationMessageVisible() {

        return !quantityField.getAttribute("validationMessage").isEmpty();
    }

    public String getValidationMessageText() {

        return quantityField.getAttribute("validationMessage");
    }
}
