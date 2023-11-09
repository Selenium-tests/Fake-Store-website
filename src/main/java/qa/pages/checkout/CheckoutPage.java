package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.pages.addressform.AddressForm;

import java.util.List;

public class CheckoutPage extends BasePage {

    private AddressForm addressForm;
    private final CreditCardForm creditCardForm;
    public CheckoutPage(WebDriver driver) {

        super(driver);

        this.addressForm = null;
        this.creditCardForm = new CreditCardForm(driver);
    }

    @FindBy(id = "terms")
    WebElement termsCheckbox;

    @FindBy(css = "button[name='woocommerce_checkout_place_order']")
    WebElement submitButton;

    @FindBy(className = "woocommerce-terms-and-conditions-link")
    WebElement termsLink;

    @FindBy(className = "woocommerce-terms-and-conditions")
    List<WebElement> termsAndConditions;

    public void clickTermsCheckbox() {

        termsCheckbox.click();
    }

    public void clickSubmitButton() {

        clickElement(submitButton);
    }

    public void setAddressForm(AddressForm addressForm) {

        this.addressForm = addressForm;
    }

    public void clickTermsLink() {

        clickElement(termsLink);
    }

    public CreditCardForm getCreditCardForm() {

        return creditCardForm;
    }

    public boolean isTermsAndConditionsTextBoxVisible() {

        return !(termsAndConditions.isEmpty());
    }
}
