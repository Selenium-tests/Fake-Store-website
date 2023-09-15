package qa.base;

import io.cucumber.java.et.Ja;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickElement(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public String getUrl() {

        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {

        return driver;
    }
}
