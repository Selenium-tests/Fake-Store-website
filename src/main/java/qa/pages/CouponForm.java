package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class CouponForm extends BasePage {

    private final Actions actions;
    public CouponForm(WebDriver driver) {

        super(driver);

        actions = new Actions(driver);
    }

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement applyCouponButton;

    public void clickCouponCodeField() {

        actions.click(couponCodeField).perform();
    }

    public void setCouponCode(String code) {

        couponCodeField.sendKeys(code);
    }

    public void clickApplyCouponButton() {

        clickElement(applyCouponButton);
    }
}
