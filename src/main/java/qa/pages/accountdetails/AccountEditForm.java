package qa.pages.accountdetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class AccountEditForm extends BasePage {

    public AccountEditForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "account_first_name")
    WebElement firstNameField;

    @FindBy(id = "account_last_name")
    WebElement lastNameField;

    @FindBy(id = "account_display_name")
    WebElement displayNameField;

    @FindBy(id = "account_email")
    WebElement emailForm;

    public AccountEditForm setFirstName(String firstName) {

        firstNameField.sendKeys(firstName);
        return this;
    }

    public AccountEditForm setLastName(String lastName) {

        lastNameField.sendKeys(lastName);
        return this;
    }

    public AccountEditForm setDisplayName(String displayName) {

        displayNameField.sendKeys(displayName);
        return this;
    }

    public void setEmail(String email) {

        emailForm.sendKeys(email);
    }
}
