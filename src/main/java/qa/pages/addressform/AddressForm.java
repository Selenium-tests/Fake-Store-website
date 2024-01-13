package qa.pages.addressform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.enums.PerformType;
import qa.tobyclass.ByFinder;


public class AddressForm extends BasePage {

    private final CountryDropdownList countryDropdownList;
    private final String prefix;

    public AddressForm(WebDriver driver, String prefix) {

        super(driver);

        this.prefix = prefix;

        countryDropdownList = new CountryDropdownList(driver);
    }

    @FindBy(css = "[name='save_address']")
    WebElement submitButton;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    private String getPrefix() {

        return prefix;
    }

    private void fill(By locator, String text) {

        WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        getInteractions().fill(element, PerformType.CLASS_METHOD, text);
    }

    public void setFirstName(String firstName) throws IllegalAccessException {

        fill(By.id(prefix + "_first_name"), firstName);
    }

    public void setLastName(String lastName) throws IllegalAccessException {

        fill(By.id(prefix + "_last_name"), lastName);
    }

    public void setCompany(String company) throws IllegalAccessException {

        fill(By.id(prefix + "_company"), company);
    }

    public void setAddress1(String address) throws IllegalAccessException {

        fill(By.id(prefix + "_address_1"), address);
    }

    public void setAddress2(String address) throws IllegalAccessException {

        fill(By.id(prefix + "_address_2"), address);
    }

    public void setPostcode(String postcode) throws IllegalAccessException {

        fill(By.id(prefix + "_postcode"), postcode);
    }

    public void setCity(String city) throws IllegalAccessException {

        fill(By.id(prefix + "_city"), city);
    }

    public void setPhone(String phone) throws IllegalAccessException {

        fill(By.id(prefix + "_phone"), phone);
    }

    public void setEmail(String email) throws IllegalAccessException {

        fill(By.id(prefix + "_email"), email);
    }

    public void clickSubmitButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        getInteractions().click(submitButton, PerformType.JS_EXECUTOR);
    }

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public void waitForErrorMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ByFinder.getByFromWebElement(errorMessage)));
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }
}
