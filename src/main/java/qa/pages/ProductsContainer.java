package qa.pages;

import io.cucumber.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import qa.base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsContainer extends BasePage {

    private List<WebElement> products;

    Map<String, String> xpaths = new HashMap<>() {{

        put("Nowości", ".//section[@class='storefront-product-section storefront-recent-products']");
        put("Popularne", ".//section[@class='storefront-product-section storefront-popular-products']");
        put("W promocji", ".//section[@class='storefront-product-section storefront-on-sale-products']");
        put("Bestsellery", ".//section[@class='storefront-product-section storefront-best-selling-products']");
    }};

    public ProductsContainer(WebDriver driver) {

        super(driver);
    }

    public void setCategory(String category) {

        WebElement locator = getDriver().findElement(By.xpath(xpaths.get(category)));
        products = locator.findElements(By.xpath(".//li[@class]"));
    }

    public void clickAddToCartButton(int index) {

        WebElement button = products.get(index).findElement(By.xpath(".//a[@rel='nofollow']"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(button).click().perform();

    }
}
