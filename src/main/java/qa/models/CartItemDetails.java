package qa.models;

import lombok.Getter;
import qa.support.PriceParser;

@Getter
public class CartItemDetails {

    private final double amount;

    public CartItemDetails(String quantity, String price) {

        this.amount = PriceParser.parse(price) * Double.parseDouble(quantity);
    }
}
