package qa.factories;

import org.openqa.selenium.WebDriver;
import qa.pages.checkout.CreditCardForm;

public class CreditCardFormFactory {

    public static CreditCardForm get(WebDriver driver) {

        CreditCardForm creditCardForm = new CreditCardForm(driver);

        creditCardForm.setCardNumber("4242424242424242 ");
        creditCardForm.setExpirationDate("12/25");
        creditCardForm.setCVC("354");

        return creditCardForm;
    }
}
