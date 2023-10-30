package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class CreditCardForm extends BasePage {

    private final Actions actions;
    public CreditCardForm(WebDriver driver) {

        super(driver);

        actions = new Actions(driver);
    }

    @FindBy(id = "stripe-card-element")
    WebElement cardNumberField;

    @FindBy(id = "stripe-exp-element")
    WebElement expirationDateField;

    @FindBy(id = "stripe-cvc-element")
    WebElement cvcField;

    @FindBy(css = "div[class='stripe-source-errors']")
    List<WebElement> incorrectCardNumberMessage;

    private void set(WebElement element, String data) {

        actions.moveToElement(element).click().perform();
        actions.sendKeys(data).perform();
    }

    public void setCardNumber(String cardNumber) {

        set(cardNumberField, cardNumber);
    }

    public void setExpirationDate(String expirationDate) {

        set(expirationDateField, expirationDate);
    }

    public void setCVC(String CVC) {

        set(cvcField, CVC);
    }

    public boolean isIncorrectCardNumberMessageVisible() {

        return !(incorrectCardNumberMessage.isEmpty());
    }

    public String getIncorrectCardNumberMessageText() {

        return incorrectCardNumberMessage.get(0).getText();
    }
}
