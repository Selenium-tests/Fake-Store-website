package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "username")
    WebElement usernameForm;

    @FindBy(id = "password")
    WebElement passwordForm;

    @FindBy(name = "login")
    WebElement submitButton;

    @FindBy(xpath = ".//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;

    public void setUsername(String username) {

        usernameForm.sendKeys(username);
    }

    public void setPassword(String password) {

        passwordForm.sendKeys(password);
    }

    public void clickSubmitButton() {

        submitButton.click();
    }

    public boolean isErrorMessageDisplayed() {

        return !errorMessage.isEmpty();
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }
}
