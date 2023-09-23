package qa.utils;

public class PriceParser {

    private static final String symbol = " zł";

    public static double parse(String price) {

        String substring = price.substring(0, price.length() - symbol.length());
        String result = substring.replace(" ", "").replace(",", ".");

        return Double.parseDouble(result);
    }
}
