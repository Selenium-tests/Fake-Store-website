package qa.enums;

public enum AddressFormMethods {

    ALL("all"),
    SET_FIRST_NAME("setFirstName"),
    SET_LAST_NAME("setLastName"),
    SET_COMPANY("setCompany"),
    SET_ADDRESS_1("setAddress1"),
    SET_ADDRESS_2("setAddress2"),
    SET_POSTCODE("setPostcode"),
    SET_CITY("setCity"),
    SET_PHONE("setPhone"),
    SET_EMAIL("setEmail");

    private final String name;

    AddressFormMethods(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
