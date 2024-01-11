package qa.pages.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;

public class CouponForm extends BasePage {

    public CouponForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement applyCouponButton;

    public void clickCouponCodeField() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(couponCodeField));
        getInteractions().click(couponCodeField, PerformType.JS_EXECUTOR);
    }

    public void setCouponCode(String code) {

        getInteractions().fill(couponCodeField, PerformType.CLASS_METHOD, code);
    }

    public void clickApplyCouponButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(applyCouponButton));
        getInteractions().click(applyCouponButton, PerformType.JS_EXECUTOR);
    }
}
