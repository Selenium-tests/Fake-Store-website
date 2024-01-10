package qa.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.pages.addressform.AddresseFormNavigation;

import java.util.List;

public class Account extends BasePage {

    private final AddresseFormNavigation addresseFormNavigation;

    public Account(WebDriver driver) {

        super(driver);

        addresseFormNavigation = new AddresseFormNavigation(driver);
    }

    @FindBy(xpath = ".//ul[@class='phoen_nav_tab']")
    List<WebElement> navigation;

    public boolean areNavigationButtonsVisible() {

        return !navigation.isEmpty();
    }

    public void clickLink(String linkText) throws IllegalAccessException {

        WebElement link = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.linkText(linkText))));
        getInteractions().click(link, PerformType.JS_EXECUTOR);
    }

    public AddresseFormNavigation getAddresses() {

        return addresseFormNavigation;
    }
}
