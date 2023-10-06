package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class Account extends BasePage {

    private final Addresses addresses;

    public Account(WebDriver driver) {

        super(driver);

        addresses = new Addresses(driver);
    }

    @FindBy(xpath = ".//ul[@class='phoen_nav_tab']")
    List<WebElement> navigation;

    public boolean areNavigationButtonsVisible() {

        return !navigation.isEmpty();
    }

    public void clickLink(String linkText) {

        clickElement(getDriver().findElement(By.linkText(linkText)));
    }

    public Addresses getAddresses() {

        return addresses;
    }
}
