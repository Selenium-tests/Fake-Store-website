package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;

public class Row extends BasePage {

    private WebElement removeButton;
    private WebElement productName;
    private WebElement amountField;
    private WebElement price;
    private WebElement totalPrice;

    public Row(WebDriver driver) {

        super(driver);
    }

    public void setRow(WebElement product) {

        removeButton = product.findElement(By.xpath(".//a[@class='remove']"));
        productName = product.findElement(By.className("product-name"));
        amountField = product.findElement(By.xpath(".//input[@type='number']"));
        price = product.findElement(By.xpath(".//span[@class='woocommerce-Price-amount amount']"));
        totalPrice = product.findElement(By.xpath(".//td[@class='product-subtotal']"));
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

    public void setAmount(String amount) {

        amountField.clear();
        amountField.sendKeys(amount);
    }

    public String getTotalPrice() {

        return totalPrice.getText();
    }
}
