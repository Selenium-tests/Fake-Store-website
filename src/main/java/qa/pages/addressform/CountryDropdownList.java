package qa.pages.addressform;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithActions;
import qa.interactions.formfillable.FillWithSendKeysMethod;

import java.util.List;


public class CountryDropdownList extends BasePage {

    public CountryDropdownList(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithActions(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    @FindBy(xpath = ".//span[@class='select2-selection__arrow']")
    WebElement arrow;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement searchField;

    @FindBy(xpath = ".//li[@class='select2-results__option select2-results__message']")
    List<WebElement> message;

    public void clickArrow() throws IllegalAccessException {

        clickable.click(arrow);
    }

    public void setCountry(String country) throws IllegalAccessException {

        formFillable.fill(searchField, country);
    }

    public void submit() throws IllegalAccessException {

        formFillable.fill(searchField, Keys.ENTER);
    }

    public boolean isMessageDisplayed() {

        return !(message.isEmpty());
    }
}
