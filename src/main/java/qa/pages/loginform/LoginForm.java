package qa.pages.loginform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.interactions.clickable.ClickWithClickMethod;
import qa.interactions.formfillable.FillWithSendKeysMethod;
import qa.tobyclass.ByFinder;

import java.util.List;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithClickMethod(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    @FindBy(id = "username")
    WebElement usernameForm;

    @FindBy(id = "password")
    WebElement passwordForm;

    @FindBy(name = "login")
    WebElement submitButton;

    @FindBy(xpath = ".//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;

    public void setUsername(String username) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(usernameForm)));
        getInteractions().fill(usernameForm, PerformType.CLASS_METHOD, username);
    }

    public void setPassword(String password) {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordForm));
        getInteractions().fill(passwordForm, PerformType.CLASS_METHOD, password);
    }

    public void clickSubmitButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        getInteractions().click(submitButton, PerformType.CLASS_METHOD);
    }

    public boolean isErrorMessageDisplayed() {

        return !errorMessage.isEmpty();
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }
}
