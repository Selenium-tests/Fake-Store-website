package qa.pages.siteheadercart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;

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

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(cartMenu));
        getInteractions().click(cartMenu, PerformType.CLASS_METHOD);
    }
}
