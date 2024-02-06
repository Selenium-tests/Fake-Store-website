package qa.support;

import org.openqa.selenium.WebDriver;
import qa.pages.checkout.CreditCardForm;
import qa.models.CreditCardData;

public class CreditCardFormFiller {

    private static final CreditCardData creditCardData = new CreditCardData("4242424242424242", "09/25", "332");

    public static void fill(WebDriver driver) {

        CreditCardForm creditCardForm = new CreditCardForm(driver);
        creditCardForm.setCreditCardData(creditCardData);
    }
}
