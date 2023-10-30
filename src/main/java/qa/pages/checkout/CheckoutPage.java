package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.pages.addressform.AddressForm;

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

    public void clickTermsCheckbox() {

        termsCheckbox.click();
    }

    public void clickSubmitButton() {

        clickElement(submitButton);
    }

    public void setAddressForm(AddressForm addressForm) {

        this.addressForm = addressForm;
    }

    public CreditCardForm getCreditCardForm() {

        return creditCardForm;
    }
}
