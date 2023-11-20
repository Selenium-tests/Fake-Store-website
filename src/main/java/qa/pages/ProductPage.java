package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
    }

    @FindBy(xpath = ".//h1[@class='product_title entry-title']")
    WebElement productTitle;

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement price;

    @FindBy(xpath = ".//button[@name='add-to-cart']")
    WebElement addToCartButton;

    public String getProductTitle() {

        return productTitle.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void clickAddToCartButton() throws IllegalAccessException {

        clickable.click(addToCartButton);
    }
}
