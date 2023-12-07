package qa.enums;

public enum CreditCardFormMethods {

    ALL("all"),
    SET_CVC("setCVC"),
    SET_CARD_NUMBER("setCardNumber"),
    SET_EXPIRATION_DATE("setExpirationDate");

    private final String name;

    CreditCardFormMethods(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
