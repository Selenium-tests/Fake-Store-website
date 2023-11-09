package qa.factories;

import org.openqa.selenium.WebDriver;
import qa.pages.addressform.AddressForm;

public class AddressFormFactory {

    public static AddressForm get(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutFirstName(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutLastName(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutAddress(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutPostcode(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutCity(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setPhone("111222333");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutPhone(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setEmail("annkoczuba@gmail.com");

        return addressForm;
    }

    public static AddressForm withoutEmail(WebDriver driver) {

        AddressForm addressForm = new AddressForm(driver, "billing");

        addressForm.getCountryDropdownList().clickArrow();
        addressForm.getCountryDropdownList().setCountry("Polska");
        addressForm.getCountryDropdownList().submit();
        addressForm.setFirstName("Anna");
        addressForm.setLastName("Koczuba");
        addressForm.setCompany("MaxArt");
        addressForm.setAddress1("ul. Koszarska 5a");
        addressForm.setPostcode("45-400");
        addressForm.setCity("Koszalin");
        addressForm.setPhone("111222333");

        return addressForm;
    }
}
