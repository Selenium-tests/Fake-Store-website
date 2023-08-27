package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class Account extends BasePage {

    public Account(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//ul[@class='phoen_nav_tab']")
    List<WebElement> navigation; //my_email@gmail.com secret_password

    public boolean areNavigationButtonsVisible() {

        return !navigation.isEmpty();
    }
}
