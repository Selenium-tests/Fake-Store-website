package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class Products extends BasePage {

    public Products(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//p[@class='woocommerce-result-count']")
    List<WebElement> resultCount;

    @FindBy(xpath = ".//ul[@class='products columns-3']")
    WebElement productsColumns;

    public boolean isResultCountEmpty() {

        return resultCount.isEmpty();
    }

    public String getResultCountText() {

        return resultCount.get(0).getText();
    }

    public int getProductsColumnsSize() {

        List<WebElement> products = productsColumns.findElements(By.xpath(".//li[@class]"));

        return products.size();
    }
}
