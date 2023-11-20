package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithClickMethod;
import qa.interactions.formfillable.FillWithSendKeysMethod;

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

        formFillable.fill(usernameForm, username);
    }

    public void setPassword(String password) throws IllegalAccessException {

        formFillable.fill(passwordForm, password);
    }

    public void clickSubmitButton() throws IllegalAccessException {

        clickable.click(submitButton);
    }

    public boolean isErrorMessageDisplayed() {

        return !errorMessage.isEmpty();
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }
}
