package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.interactions.formfillable.FillWithSendKeysMethod;

public class Row extends BasePage {

    private WebElement removeButton;
    private WebElement productName;
    private WebElement quantityField;
    private WebElement price;
    private WebElement totalPrice;

    public Row(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    public void setRow(WebElement product) {

        removeButton = product.findElement(By.xpath(".//a[@class='remove']"));
        productName = product.findElement(By.className("product-name"));
        quantityField = product.findElement(By.cssSelector("input[class='input-text qty text']"));
        price = product.findElement(By.cssSelector("span[class='woocommerce-Price-amount amount']"));
        totalPrice = product.findElement(By.className("product-subtotal"));
    }

    public void clickRemoveButton() throws IllegalAccessException {

        clickable.click(removeButton);
    }

    public String getName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void setQuantity(String quantity) throws IllegalAccessException {

        formFillable.fill(quantityField, quantity);
    }

    public String getTotalPrice() {

        return totalPrice.getText();
    }

    public boolean isValidationMessageVisible() {

        return !quantityField.getAttribute("validationMessage").isEmpty();
    }

    public String getValidationMessageText() {

        return quantityField.getAttribute("validationMessage");
    }
}
