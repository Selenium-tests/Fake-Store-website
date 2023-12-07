package qa.pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class ShoppingCartSummary extends BasePage {

    public ShoppingCartSummary(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//td[@data-title='Kwota']")
    WebElement amount;

    @FindBy(xpath = ".//tr[@class='cart-discount coupon']")
    WebElement couponDescription;

    @FindBy(xpath = ".//td[@data-title='Suma']")
    WebElement sum;

    public String getAmount() {

        return amount.getText();
    }

    public String getCouponDescription(String couponCode) {

        String xpath = ".//tr[@class='cart-discount coupon-" + couponCode + "']";

        WebElement element = getDriver().findElement(By.xpath(xpath));

        return element.findElement(By.xpath(".//th")).getText();
    }

    public String getSum() {

        return sum.getText();
    }
}
