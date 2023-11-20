package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithClickMethod;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);

        setClickable(new ClickWithClickMethod(driver));
    }

    public void click(String index) throws IllegalAccessException {

        clickable.click(getDriver().findElement(By.linkText(index)));
    }
}
