package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.interactions.formfillable.FillWithActions;

import java.util.List;

public class CreditCardForm extends BasePage {

    public CreditCardForm(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
        setFormFillable(new FillWithActions(driver));
    }

    @FindBy(id = "stripe-card-element")
    public WebElement cardNumberField;

    @FindBy(id = "stripe-exp-element")
    public WebElement expirationDateField;

    @FindBy(id = "stripe-cvc-element")
    public WebElement cvcField;

    @FindBy(css = "div[class='stripe-source-errors']")
    List<WebElement> incorrectCardNumberMessage;

    public void setCardNumber(String cardNumber) throws IllegalAccessException {

        formFillable.fill(cardNumberField, cardNumber);
    }

    public void setExpirationDate(String expirationDate) throws IllegalAccessException {

        formFillable.fill(expirationDateField, expirationDate);
    }

    public WebElement get() {

        return expirationDateField;
    }

    public void setCVC(String CVC) throws IllegalAccessException {

        formFillable.fill(cvcField, CVC);
    }

    public boolean isIncorrectCardNumberMessageVisible() {

        return !(incorrectCardNumberMessage.isEmpty());
    }

    public String getIncorrectCardNumberMessageText() {

        return incorrectCardNumberMessage.get(0).getText();
    }
}
