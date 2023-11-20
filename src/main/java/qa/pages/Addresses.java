package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;

public class Addresses extends BasePage {

    public Addresses(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithJSExecutor(driver));
    }

    @FindBy(xpath = ".//div[@class='u-columns woocommerce-Addresses col2-set addresses']")
    WebElement columns;

    public void clickAddButton(int index) throws IllegalAccessException {

        clickable.click(columns.findElements(By.xpath(".//a[@href]")).get(index));
    }
}
