package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "menu-menu")
    WebElement navMenu;

    public void click(String index) {

        getDriver().findElement(By.linkText(index)).click();
    }
}
