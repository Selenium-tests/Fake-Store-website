package qa.pages.accountdetails;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class AccountDetails extends BasePage {

    @Getter
    private final AccountEditForm accountEditForm;
    @Getter
    private final PasswordChangeForm passwordChangeForm;

    public AccountDetails(WebDriver driver) {

        super(driver);

        accountEditForm = new AccountEditForm(driver);
        passwordChangeForm = new PasswordChangeForm(driver);
    }

    @FindBy(css = "[name='save_account_details']")
    WebElement submitButton;
}
