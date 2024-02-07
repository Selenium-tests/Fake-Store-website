package qa.models;

import lombok.Getter;
import qa.support.PriceParser;

public class CartItemDetails {

    @Getter
    private String quantity;
    private final double amount;

    public CartItemDetails(String quantity, String price) {

        this.quantity = quantity;
        this.amount = PriceParser.parse(price) * Double.parseDouble(quantity);
    }

    public double getAmount() {

        return amount;
    }
}
