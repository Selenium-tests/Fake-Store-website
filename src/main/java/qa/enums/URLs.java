package qa.enums;

public enum URLs {

    LOGIN_PAGE("https://fakestore.testelka.pl/moje-konto/"),
    ADDRESS_EDITING_SECTION("https://fakestore.testelka.pl/moje-konto/edytuj-adres/"),
    BILLING_ADDRESS_FORM("https://fakestore.testelka.pl/moje-konto/edytuj-adres/rozliczeniowy/"),
    SHOPPING_CART("https://fakestore.testelka.pl/koszyk/"),
    GRAN_KOSCIELCOW_PRODUCT_PAGE("https://fakestore.testelka.pl/product/gran-koscielcow/"),
    CHECKOUT_PAGE("https://fakestore.testelka.pl/zamowienie/"),
    RECEIVED_ORDER_PAGE("https://fakestore.testelka.pl/zamowienie/zamowienie-otrzymane/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
