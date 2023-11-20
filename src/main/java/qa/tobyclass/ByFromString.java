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

        /*return switch (locatorType) {
            case "css selector":
            case "By.cssSelector": By.cssSelector(locatorValue);
            case "By.id" -> By.id(locatorValue);
            case "By.linkText" -> By.linkText(locatorValue);
            case "By.partialLinkText" -> By.partialLinkText(locatorValue);
            case "By.tagName" -> By.tagName(locatorValue);
            case "By.name" -> By.name(locatorValue);
            case "By.className" -> By.className(locatorValue);
            case "By.xpath" -> By.xpath(locatorValue);
            default ->
                    throw new IllegalStateException("Cannot define locator for WebElement definition " + locatorToString);
        };*/
    }
}
