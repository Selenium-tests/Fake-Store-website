package qa.utils;

import lombok.Getter;

@Getter
public class CreditCardData {

    private final String number;
    private final String expirationDate;
    private final String cvc;

    public CreditCardData(String number, String expirationDate, String cvc) {

        this.number = number;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
    }
}
