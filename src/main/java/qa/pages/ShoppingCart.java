package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ShoppingCart extends BasePage {

    private List<WebElement> products;
    private WebElement removeButton;

    public ShoppingCart(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement contents;

    public void findProducts() {

        products = contents.findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

    }
}
