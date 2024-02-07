package qa.pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.pages.quantityfield.QuantityField;

import java.util.List;

public class Table extends BasePage {

    List<WebElement> rows;

    public Table(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "table[class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement table;

    public void findRows() {

        rows = table.findElements(By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item']"));
    }

    public int getRowsCount() {

        return rows.size();
    }

    public String getProductName(int row) {

        return rows.get(row).findElement(By.className("product-name")).getText();
    }

    public String getProductPrice(int row) {

        return rows.get(row).findElement(By.cssSelector("span[class='woocommerce-Price-amount amount']")).getText();
    }

    public void clickRemoveButton(int row) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(rows.get(row).findElement(By.className("product-remove")))).click();
    }

    public QuantityField getQuantityField(int row) {

        return new QuantityField(getDriver(), rows.get(row).findElement(By.cssSelector(".input-text.qty.text")));
    }
}
