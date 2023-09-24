package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class SiteHeaderCart extends BasePage {

    public SiteHeaderCart(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement priceAmount;

    @FindBy(id = "site-header-cart")
    WebElement cartMenu;

    public String getPrice() {

        return priceAmount.getText();
    }

    public void clickCartMenu() {

        cartMenu.click();
    }
}