package qa.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;
import qa.models.CreditCardData;


public class CreditCardForm extends BasePage {

    public CreditCardForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "#stripe-card-element iframe")
    public WebElement cardNumberFrame;

    @FindBy(css = "#stripe-exp-element iframe")
    WebElement expirationDateFrame;

    @FindBy(css = "#stripe-cvc-element iframe")
    WebElement cvcFrame;

    @FindBy(css = ".InputElement[name='cardnumber']")
    public WebElement cardNumberField;

    @FindBy(css = "[name='exp-date']")
    public WebElement expirationDateField;

    @FindBy(css = "[name='cvc']")
    public WebElement cvcField;

    @FindBy(css = "div[class='stripe-source-errors']")
    WebElement incorrectCardNumberMessage;

    private void action(WebElement frame, WebElement element, String text) {

        getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        getInteractions().fill(element, PerformType.CLASS_METHOD, text);
        getDriver().switchTo().parentFrame();
    }

    public void setCreditCardData(CreditCardData data) {

        setCardNumber(data.getNumber());
        setExpirationDate(data.getExpirationDate());
        setCVC(data.getCvc());
    }

    public void setCardNumber(String cardNumber) {

        action(cardNumberFrame, cardNumberField, cardNumber);
    }

    public void setExpirationDate(String expirationDate) {

        action(expirationDateFrame, expirationDateField, expirationDate);
    }

    public void setCVC(String CVC) {

        action(cvcFrame, cvcField, CVC);
    }

    public void waitForIncorrectCardNumberMessageLocator() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(incorrectCardNumberMessage)));
    }

    public String getIncorrectCardNumberMessageText() throws IllegalAccessException {

        waitForIncorrectCardNumberMessageLocator();

        return incorrectCardNumberMessage.getText();
    }
}
