package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;

import java.util.List;

public class CheckoutPage extends BasePage {

    private final CreditCardForm creditCardForm;
    public CheckoutPage(WebDriver driver) {

        super(driver);

        this.creditCardForm = new CreditCardForm(driver);
    }

    @FindBy(id = "terms")
    WebElement termsCheckbox;

    @FindBy(css = "button[name='woocommerce_checkout_place_order']")
    public WebElement submitButton;

    @FindBy(className = "woocommerce-terms-and-conditions-link")
    WebElement termsLink;

    @FindBy(className = "woocommerce-terms-and-conditions")
    List<WebElement> termsAndConditions;

    public void clickTermsCheckbox() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        getInteractions().click(termsCheckbox, PerformType.JS_EXECUTOR);
    }

    public void clickSubmitButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        getInteractions().click(submitButton, PerformType.JS_EXECUTOR);
    }

    public void clickTermsLink() throws IllegalAccessException {

        clickable.click(termsLink);
    }

    public CreditCardForm getCreditCardForm() {

        return creditCardForm;
    }

    public boolean isTermsAndConditionsTextBoxVisible() {

        return !(termsAndConditions.isEmpty());
    }
}
