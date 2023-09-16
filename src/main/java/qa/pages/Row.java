package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;

public class Row extends BasePage {

    private WebElement removeButton;
    private WebElement productName;
    private WebElement price;
    public Row(WebDriver driver) {

        super(driver);
    }

    public void setRow(WebElement product) {

        removeButton = product.findElement(By.xpath(".//a[@class='remove']"));
        productName = product.findElement(By.className("product-name"));
        price = product.findElement(By.xpath(".//span[@class='woocommerce-Price-amount amount']"));
    }

    public void clickRemoveButton() {

        removeButton.click();
    }

    public String getName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }
}
