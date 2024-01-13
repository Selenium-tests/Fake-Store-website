package qa.pages.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;

public class CouponForm extends BasePage {

    public CouponForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement applyCouponButton;

    public void clickCouponCodeField() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(couponCodeField)));
    }

    public void setCouponCode(String code) {

        getInteractions().fill(couponCodeField, PerformType.CLASS_METHOD, code);
    }

    public void clickApplyCouponButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(applyCouponButton)));
        getInteractions().click(applyCouponButton, PerformType.JS_EXECUTOR);
    }
}
