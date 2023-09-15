package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "menu-menu")
    WebElement navMenu;

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement priceAmount;

    @FindBy(id = "site-header-cart")
    WebElement siteHeaderCart;

    public void click(String index) {

        getDriver().findElement(By.linkText(index)).click();
    }

    public String getPrice() {

        return priceAmount.getText();
    }

    public void clickSiteHeaderCart() {

        siteHeaderCart.click();
    }
}
