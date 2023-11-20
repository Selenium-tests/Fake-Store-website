package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductThumbnail extends BasePage {

    private WebElement product;
    private WebElement title;
    private WebElement price;
    private WebElement addToCartButton;
    private WebElement seeCartButton;
    private final FluentWait<WebDriver> fluentWait;

    public ProductThumbnail(WebDriver driver) {

        super(driver);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

        setClickable(new ClickWithJSExecutor(driver));
    }

    public void setThumbnail(String xpath, int index) {

        WebElement category = getDriver().findElement(By.xpath(xpath));
        List<WebElement> products = category.findElements(By.xpath(".//li[@class]"));

        product = products.get(index);
        title = product.findElement(By.xpath(".//h2[@class='woocommerce-loop-product__title']"));
        price = product.findElement(By.xpath(".//span[@class='price']"));
        addToCartButton = products.get(index).findElement(By.linkText("Dodaj do koszyka"));
    }

    public String getTitle() {

        return title.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void clickTheProductLink() throws IllegalAccessException {

        clickable.click(title);
    }

    public void clickAddToCartButton() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].click()", addToCartButton);
    }

    public void waitForSeeCartButton() {

        seeCartButton = fluentWait.until(driver->product.findElement(By.xpath(".//a[@title='Zobacz koszyk']")));
    }

    public void clickSeeCartButton() {

        seeCartButton.click();
    }
}
