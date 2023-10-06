package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class Addresses extends BasePage {

    public Addresses(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='u-columns woocommerce-Addresses col2-set addresses']")
    WebElement columns;

    public void clickAddButton(int index) {

        clickElement(columns.findElements(By.xpath(".//a[@href]")).get(index));
    }
}
