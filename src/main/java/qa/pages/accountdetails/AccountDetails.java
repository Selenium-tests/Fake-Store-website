package qa.pages.accountdetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class AccountDetails extends BasePage {

    private final AccountEditForm accountEditForm;
    private final PasswordChangeForm passwordChangeForm;

    public AccountDetails(WebDriver driver) {

        super(driver);

        accountEditForm = new AccountEditForm(driver);
        passwordChangeForm = new PasswordChangeForm(driver);
    }

    @FindBy(css = "[name='save_account_details']")
    WebElement submitButton;

    public AccountEditForm getAccountEditForm() {

        return accountEditForm;
    }

    public PasswordChangeForm getPasswordChangeForm() {

        return passwordChangeForm;
    }
}
