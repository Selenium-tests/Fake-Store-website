package qa.pages.mainmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    public void click(String index) throws IllegalAccessException {

        WebElement link = getWebDriverWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.linkText(index))));
        getInteractions().click(link, PerformType.CLASS_METHOD);
    }
}
