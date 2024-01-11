package qa.pages.productthumbnail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;
import qa.utils.ThumbnailData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThumbnailProvider extends BasePage {

    private static final String xpathPart = ".//section[@class='storefront-product-section storefront";
    private static final Map<String, String> categoriesMap = new HashMap<>() {{
            put("Nowości", "-recent-products']");
            put("Popularne", "-popular-products']");
            put("W promocji", "-on-sale-products']");
            put("Bestsellery", "-best-selling-products']");
    }};

    public ThumbnailProvider(WebDriver driver) {

        super(driver);
    }

    public static ProductThumbnail getThumbnail(WebDriver driver, ThumbnailData data) {

        ProductThumbnail productThumbnail = new ProductThumbnail(driver);

        WebElement category = driver.findElement(By.xpath(xpathPart + categoriesMap.get(data.getCategory())));
        List<WebElement> products = category.findElements(By.xpath(".//li[@class]"));

        WebElement parent = products.get(data.getNumber());
        WebElement productName = parent.findElement(By.xpath(".//h2[@class='woocommerce-loop-product__title']"));
        WebElement price = parent.findElement(By.xpath(".//span[@class='price']"));
        WebElement addToCartButton = parent.findElement(By.linkText("Dodaj do koszyka"));

        productThumbnail.setParent(parent);
        productThumbnail.setProductNameLocator(productName);
        productThumbnail.setPriceLocator(price);
        productThumbnail.setAddToCartButtonLocator(addToCartButton);

        return productThumbnail;
    }
}
