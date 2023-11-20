package qa.tobyclass;

import org.openqa.selenium.By;

public class ByFromString {

    public static By getByFromString(String locatorToString) {

        String[] locatorSplit = locatorToString.split(": ");

        if (locatorSplit.length != 2) {

            throw new IllegalStateException(String.format("Locator definition does not had 2 elements for %s locator", locatorToString));
        }

        String using = locatorSplit[0];
        String value = locatorSplit[1];

        if (using.equals("xpath")) {

            String replacement = "";

            value = value.substring(0, value.length() - 3) + replacement;
        }

        switch (using) {
            case "By.cssSelector", "css selector" -> {
                return By.cssSelector(value);
            }
            case "By.id", "id" -> {
                return By.id(value);
            }
            case "By.linkText", "link text" -> {
                return By.linkText(value);
            }
            case "By.partialLinkText", "partial link text" -> {
                return By.partialLinkText(value);
            }
            case "By.tagName", "tag name" -> {
                return By.tagName(value);
            }
            case "By.name", "name" -> {
                return By.name(value);
            }
            case "By.className", "class name" -> {
                return By.className(value);
            }
            case "By.xpath", "xpath" -> {
                return By.xpath(value);
            }
            default -> {
                throw new IllegalStateException("Cannot define locator for WebElement definition " + locatorToString);
            }
        }
    }
}
