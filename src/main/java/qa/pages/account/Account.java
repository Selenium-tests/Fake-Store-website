package qa.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.pages.addressform.AddresseFormNavigation;

import java.util.List;

public class Account extends BasePage {

    private final AddresseFormNavigation addresseFormNavigation;

    public Account(WebDriver driver) {

        super(driver);

        addresseFormNavigation = new AddresseFormNavigation(driver);
        setClickable(new ClickWithJSExecutor(driver));
    }

    @FindBy(xpath = ".//ul[@class='phoen_nav_tab']")
    List<WebElement> navigation;

    public boolean areNavigationButtonsVisible() {

        return !navigation.isEmpty();
    }

    public void clickLink(String linkText) throws IllegalAccessException {

        clickable.click(getDriver().findElement(By.linkText(linkText)));
    }

    public AddresseFormNavigation getAddresses() {

        return addresseFormNavigation;
    }
}
