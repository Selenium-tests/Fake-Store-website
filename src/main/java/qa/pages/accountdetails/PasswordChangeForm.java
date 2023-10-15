package qa.pages.accountdetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class PasswordChangeForm extends BasePage {

    public PasswordChangeForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "password_current")
    WebElement currentPasswordField;

    @FindBy(id = "password_1")
    WebElement newPasswordField;

    @FindBy(id = "password_2")
    WebElement passwordConfirmationField;

    public void setCurrentPassword(String currentPassword) {

        currentPasswordField.sendKeys(currentPassword);
    }

    public void setNewPassword(String newPassword) {

        newPasswordField.sendKeys(newPassword);
    }

    public void confirmNewPassword(String newPassword) {

        passwordConfirmationField.sendKeys(newPassword);
    }
}
