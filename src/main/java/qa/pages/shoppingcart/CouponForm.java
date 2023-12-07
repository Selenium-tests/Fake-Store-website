package qa.pages.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.interactions.formfillable.FillWithSendKeysMethod;


public class CouponForm extends BasePage {

    public CouponForm(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;
    @FindBy(xpath = ".//button[@name='apply_coupon']")
    WebElement applyCouponButton;

    public void clickCouponCodeField() throws IllegalAccessException {

        clickable.click(couponCodeField);
    }

    public void setCouponCode(String code) throws IllegalAccessException {

        formFillable.fill(couponCodeField, code);
    }

    public void clickApplyCouponButton() throws IllegalAccessException {

        clickable.click(applyCouponButton);
    }
}
