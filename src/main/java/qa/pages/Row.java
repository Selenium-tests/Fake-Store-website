package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;

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

    public void clickRemoveButton() {

        clickElement(removeButton);
    }

    public String getName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void setQuantity(String quantity) {

        quantityField.clear();
        quantityField.sendKeys(quantity);
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
