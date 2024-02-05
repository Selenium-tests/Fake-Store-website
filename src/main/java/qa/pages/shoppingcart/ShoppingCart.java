package qa.pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;

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
    WebElement contents;

    @FindBy(className = "woocommerce-message")
    WebElement message;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    @FindBy(css = "div[class='cart-empty woocommerce-info']")
    WebElement emptyCartMessage;
    @FindBy(xpath = ".//button[@name='update_cart']")
    WebElement updateCartButton;
    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    WebElement checkoutButton;

    public void findProducts() {

        products = contents.findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
    }

    public void findProduct(int index) {

        findProducts();

        row.setRow(products.get(index));
    }

    public Row getRow() {

        return row;
    }

    public void waitForMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(message)));
    }

    public String getMessageText() {

        return message.getText();
    }

    public void waitForErrorMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(errorMessage)));
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }

    public void waitForEmptyCartMessageLocator() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(emptyCartMessage)));
    }

    public String getEmptyCartMessageText() {

        return emptyCartMessage.getText();
    }

    public CouponForm getCouponForm() {

        return couponForm;
    }

    public ShoppingCartSummary getShoppingCartSummary() {

        return shoppingCartSummary;
    }

    public void clickUpdateCartButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(updateCartButton));
        getInteractions().click(updateCartButton, PerformType.JS_EXECUTOR);
    }

    public void clickCheckoutButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(checkoutButton));
        getInteractions().click(checkoutButton, PerformType.JS_EXECUTOR);
    }
}
