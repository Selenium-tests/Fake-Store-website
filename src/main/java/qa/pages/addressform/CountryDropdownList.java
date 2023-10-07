package qa.pages.addressform;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;


public class CountryDropdownList extends BasePage {
    public CountryDropdownList(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".select2-selection__arrow")
    WebElement button;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement searchField;

    public void clickButton() {

        clickElement(button);
    }

    public void setCountry(String country) {

        searchField.sendKeys(country + Keys.ENTER);
    }


}
