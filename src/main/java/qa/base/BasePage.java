package qa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.interactions.clickable.Clickable;
import qa.interactions.formfillable.FormFillable;

public class BasePage {

    private final WebDriver driver;
    //private final WebDriverWait wait;
    protected Clickable clickable;
    protected FormFillable formFillable;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    private @FindBy(xpath = ".//a[@class='woocommerce-store-notice__dismiss-link']")
    WebElement notice;

    public void hideNotice() {

        notice.click();
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected void setClickable(Clickable clickable) {

        this.clickable = clickable;
    }

    protected void setFormFillable(FormFillable formFillable) {

        this.formFillable = formFillable;
    }
}
