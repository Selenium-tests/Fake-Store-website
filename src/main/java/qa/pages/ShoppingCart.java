package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ShoppingCart extends BasePage {

    private final Row row;

    public ShoppingCart(WebDriver driver) {

        super(driver);

        row = new Row(driver);
    }

    @FindBy(xpath = ".//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement contents;

    @FindBy(className = "woocommerce-message")
    List<WebElement> message;

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement applyCouponButton;

    @FindBy(xpath = ".//button[@name='update_cart']")
    WebElement updateCartButton;



    public void findProduct(int index) {

        List<WebElement> products = contents.findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        row.setRow(products.get(index));
    }

    public Row getRow() {

        return row;
    }

    public boolean isMessageVisible() {

        return !(message.isEmpty());
    }

    public void setCouponCode(String code) {

        couponCodeField.sendKeys(code);
    }

    public void clickApplyCouponButton() {

        applyCouponButton.click();
    }

    public void clickUpdateCartButton() {

        updateCartButton.click();
    }
}
