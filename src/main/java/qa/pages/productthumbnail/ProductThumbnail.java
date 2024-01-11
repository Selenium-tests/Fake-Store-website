package qa.pages.productthumbnail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;


public class ProductThumbnail extends BasePage {

    private WebElement parent;
    private WebElement productName;
    private WebElement price;
    private WebElement addToCartButton;
    private WebElement seeCartButton;

    public ProductThumbnail(WebDriver driver) {

        super(driver);
    }

    public void setParent(WebElement parent) {

        this.parent = parent;
    }

    public void setProductNameLocator(WebElement title) {

        this.productName = title;
    }

    public void setPriceLocator(WebElement price) {

        this.price = price;
    }

    public void setAddToCartButtonLocator(WebElement addToCartButton) {

        this.addToCartButton = addToCartButton;
    }
    public String getName() {

        return productName.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    public void clickTheProductLink() throws IllegalAccessException {

        clickable.click(productName);
    }

    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        getInteractions().scrollIntoView(addToCartButton);
        getInteractions().click(addToCartButton, PerformType.JS_EXECUTOR);
    }

    public void waitForSeeCartButton() {

        seeCartButton = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                parent.findElement(By.xpath(".//a[@title='Zobacz koszyk']"))
        ));
    }

    public void clickSeeCartButton() {

        waitForSeeCartButton();
        seeCartButton.click();
    }
}
