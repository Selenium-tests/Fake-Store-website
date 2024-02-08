package qa.support;

public class StringCalc {

    public static String calculate(String lhs, String rhs, String operator) {

        return switch (operator) {

            case "-" -> String.valueOf(Integer.parseInt(lhs) - Integer.parseInt(rhs));
            case "+" -> String.valueOf(Integer.parseInt(lhs) + Integer.parseInt(rhs));
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
