package qa.pages.searchengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithActions;
import qa.interactions.formfillable.FillWithSendKeysMethod;

public class SearchEngine extends BasePage {

    public SearchEngine(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithActions(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    @FindBy(className = "search-field")
    WebElement searchField;

    public void clickOnTheSearchField() throws IllegalAccessException {

        clickable.click(searchField);
    }

    public String getPlaceholderText() {

        return searchField.getAttribute("placeholder");
    }

    public void enterPhrase(String phrase) throws IllegalAccessException {

        formFillable.fill(searchField, phrase);
    }

    public void submit() {

        searchField.submit();
    }
}
