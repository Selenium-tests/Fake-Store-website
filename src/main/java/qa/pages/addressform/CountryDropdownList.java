package qa.pages.addressform;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import java.util.List;


public class CountryDropdownList extends BasePage {

    public CountryDropdownList(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//span[@class='select2-selection__arrow']")
    WebElement arrow;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement searchField;

    @FindBy(xpath = ".//li[@class='select2-results__option select2-results__message']")
    List<WebElement> message;

    public void clickArrow() {

        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(arrow));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void setCountry(String country) {

        searchField.sendKeys(country + Keys.ENTER);
    }

    public boolean isMessageDisplayed() {

        return message.isEmpty();
    }
}
