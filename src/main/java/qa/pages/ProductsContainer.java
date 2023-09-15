package qa.pages;

import org.openqa.selenium.WebDriver;
import qa.base.BasePage;
import java.util.HashMap;
import java.util.Map;

public class ProductsContainer extends BasePage {

    private final ProductThumbnail productThumbnail;

    Map<String, String> xpaths = new HashMap<>() {{

        put("Nowości", ".//section[@class='storefront-product-section storefront-recent-products']");
        put("Popularne", ".//section[@class='storefront-product-section storefront-popular-products']");
        put("W promocji", ".//section[@class='storefront-product-section storefront-on-sale-products']");
        put("Bestsellery", ".//section[@class='storefront-product-section storefront-best-selling-products']");
    }};

    public ProductsContainer(WebDriver driver) {

        super(driver);

        productThumbnail = new ProductThumbnail(driver);
    }

    public void setProductThumbnail(String category, int number) {

        productThumbnail.setThumbnail(xpaths.get(category), number);
    }

    public ProductThumbnail getProductThumbnail() {

        return productThumbnail;
    }
}
