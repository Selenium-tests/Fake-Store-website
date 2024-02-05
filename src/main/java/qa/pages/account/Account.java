package qa.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.pages.addressform.AddressFormsNavigation;

import java.util.List;

public class Account extends BasePage {

    private final AddressFormsNavigation addressFormsNavigation;

    public Account(WebDriver driver) {

        super(driver);

        addressFormsNavigation = new AddressFormsNavigation(driver);
    }

    @FindBy(xpath = ".//ul[@class='phoen_nav_tab']")
    List<WebElement> navigation;

    public boolean areNavigationButtonsVisible() {

        return !navigation.isEmpty();
    }

    public void clickLink(String linkText) {

        WebElement link = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.linkText(linkText))));
        getInteractions().click(link, PerformType.JS_EXECUTOR);
    }

    public AddressFormsNavigation getAddresses() {

        return addressFormsNavigation;
    }
}
