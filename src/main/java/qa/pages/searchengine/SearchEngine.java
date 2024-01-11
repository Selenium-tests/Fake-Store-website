package qa.pages.searchengine;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;


public class SearchEngine extends BasePage {

    public SearchEngine(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "search-field")
    WebElement searchField;

    public void clickOnTheSearchField() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(searchField));
        getInteractions().click(searchField, PerformType.JS_EXECUTOR);
    }

    public String getPlaceholderText() {

        return searchField.getAttribute("placeholder");
    }

    public void enterPhrase(String phrase) throws IllegalAccessException {

        getInteractions().fill(searchField, PerformType.CLASS_METHOD, phrase);
    }

    public void submit() {

        getInteractions().fill(searchField, PerformType.CLASS_METHOD, Keys.ENTER);
    }
}
