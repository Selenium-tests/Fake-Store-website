package qa.pages.searchengine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ResultsPage extends BasePage {

    private List<WebElement> products;

    public ResultsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//ul[@class='products columns-3']")
    List<WebElement> productsColumns;

    public boolean hasColumns() {

        return !productsColumns.isEmpty();
    }

    public void findProducts() {

        products = productsColumns.get(0).findElements(By.cssSelector("li[class]"));
    }

    public int getProductsColumnsSize() {

        return products.size();
    }

    public List<String> getProductsTitles() {

        return products.stream()
                .map(i -> i.findElement(By.cssSelector("h2")).getText())
                .toList();
    }
}
