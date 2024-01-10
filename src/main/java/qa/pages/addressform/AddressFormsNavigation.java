package qa.pages.addressform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;

public class AddressFormsNavigation extends BasePage {

    public AddressFormsNavigation(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='u-columns woocommerce-Addresses col2-set addresses']")
    WebElement columns;

    public void clickAddButton(int index) {

        WebElement link = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(columns.findElements(By.xpath(".//a[@href]")).get(index)));
        getInteractions().click(link, PerformType.JS_EXECUTOR);
    }
}
