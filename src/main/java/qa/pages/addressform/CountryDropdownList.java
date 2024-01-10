package qa.pages.addressform;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;

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

    public void clickArrow() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ByFinder.getByFromWebElement(arrow)));
        getInteractions().scrollIntoView(arrow);
        getInteractions().click(arrow, PerformType.ACTIONS);
    }

    public void setCountry(String country) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(searchField)));
        getInteractions().fill(searchField, PerformType.CLASS_METHOD, country);
    }

    public void submit() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(searchField)));
        getInteractions().fill(searchField, PerformType.CLASS_METHOD, Keys.ENTER);
    }

    public boolean isMessageDisplayed() {

        return !(message.isEmpty());
    }
}
