package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;


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
    WebElement termsAndConditions;

    @FindBy(css = ".wc-block-components-notice-banner.is-error")
    WebElement errorMessage;

    public void clickTermsCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        getInteractions().click(termsCheckbox, PerformType.JS_EXECUTOR);
    }

    public void clickSubmitButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        getInteractions().click(submitButton, PerformType.JS_EXECUTOR);
    }

    public void clickTermsLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(termsLink));
        getInteractions().click(termsLink, PerformType.CLASS_METHOD);
    }

    public CreditCardForm getCreditCardForm() {

        return creditCardForm;
    }

    public void waitForTermsAndConditionsLocator() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(termsAndConditions)));
    }

    public void waitForErrorMessageLocator() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(errorMessage)));
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }
}
