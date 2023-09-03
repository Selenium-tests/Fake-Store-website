package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class SearchEngine extends BasePage {

    Actions actions;
    public SearchEngine(WebDriver driver) {

        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(className = "search-field")
    WebElement searchField;

    public void clickOnTheSearchField() {

        actions.click(searchField).perform();
    }

    public String getPlaceholderText() {

        return searchField.getAttribute("placeholder");
    }

    public void enterPhrase(String phrase) {

        searchField.sendKeys(phrase);
    }

    public void submit() {

        searchField.submit();
    }
}
