package qa.pages.addressform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.interactions.clickable.ClickWithJSExecutor;
import qa.interactions.formfillable.FillWithSendKeysMethod;

import java.util.List;

public class AddressForm extends BasePage {

    private final CountryDropdownList countryDropdownList;
    private final String prefix;

    public AddressForm(WebDriver driver, String prefix) {

        super(driver);

        this.prefix = prefix;
        countryDropdownList = new CountryDropdownList(driver);

        setClickable(new ClickWithJSExecutor(driver));
        setFormFillable(new FillWithSendKeysMethod(driver));
    }

    @FindBy(css = "[name='save_address']")
    WebElement submitButton;

    @FindBy(className = "woocommerce-error")
    List<WebElement> errorMessage;

    private String getPrefix() {

        return prefix;
    }

    public void setFirstName(String firstName) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_first_name")), firstName);
    }

    public void setLastName(String lastName) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_last_name")), lastName);
    }

    public void setCompany(String company) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_company")), company);
    }

    public void setAddress1(String address) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_address_1")), address);
    }

    public void setAddress2(String address) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_address_2")), address);
    }

    public void setPostcode(String postcode) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_postcode")), postcode);
    }

    public void setCity(String city) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(prefix + "_city")), city);
    }

    public void setPhone(String phone) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(getPrefix() + "_phone")), phone);
    }

    public void setEmail(String email) throws IllegalAccessException {

        formFillable.fill(getDriver().findElement(By.id(getPrefix() + "_email")), email);
    }

    public void clickSubmitButton() throws IllegalAccessException {

        clickable.click(submitButton);
    }

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public boolean isErrorMessageDisplayed() {

        return !(errorMessage.isEmpty());
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }
}
