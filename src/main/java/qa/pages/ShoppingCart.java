package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ShoppingCart extends BasePage {

    private final Row row;
    private List<WebElement> products;
    private final CouponForm couponForm;
    private final ShoppingCartSummary shoppingCartSummary;

    public ShoppingCart(WebDriver driver) {

        super(driver);

        row = new Row(driver);
        couponForm = new CouponForm(driver);
        shoppingCartSummary = new ShoppingCartSummary(driver);
    }

    @FindBy(xpath = ".//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    List<WebElement> contents;

    @FindBy(className = "woocommerce-message")
    List<WebElement> message;

    @FindBy(className = "woocommerce-error")
    List<WebElement> errorMessage;

    @FindBy(css = "div[class='cart-empty woocommerce-info']")
    List<WebElement> emptyCartMessage;
    @FindBy(xpath = ".//button[@name='update_cart']")
    WebElement updateCartButton;

    public void findProducts() {

        products = contents.get(0).findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
    }

    public void findProduct(int index) {

        findProducts();

        row.setRow(products.get(index));
    }

    public boolean isContentsLocatorPresent() {

        return !(contents.isEmpty());
    }

    public Row getRow() {

        return row;
    }

    public boolean isMessageVisible() {

        return !(message.isEmpty());
    }

    public String getMessageText() {

        return message.get(0).getText();
    }

    public boolean isErrorMessageVisible() {

        return !(errorMessage.isEmpty());
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }

    public boolean isEmptyCartMessageVisible() {

        return !(emptyCartMessage.isEmpty());
    }

    public String getEmptyCartMessageText() {

        return emptyCartMessage.get(0).getText();
    }

    public CouponForm getCouponForm() {

        return couponForm;
    }

    public ShoppingCartSummary getShoppingCartSummary() {

        return shoppingCartSummary;
    }

    public void clickUpdateCartButton() {

        updateCartButton.click();
    }
}
