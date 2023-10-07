package qa.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        javascriptExecutor = (JavascriptExecutor) driver;

        PageFactory.initElements(this.driver, this);
    }

    private @FindBy(xpath = ".//a[@class='woocommerce-store-notice__dismiss-link']")
    WebElement notice;

    public void hideNotice() {

        notice.click();
    }

    protected void clickElement(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public String getUrl() {

        return driver.getCurrentUrl();
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWait() {

        return wait;
    }
}
