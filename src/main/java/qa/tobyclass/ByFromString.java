package qa.tobyclass;

import org.openqa.selenium.By;

public class ByFromString {

    public static By getByFromString(String locatorToString) {

        String[] locatorSplit = locatorToString.split(": ");

        if (locatorSplit.length != 2) {

            throw new IllegalStateException(String.format("Locator definition does not had 2 elements for %s locator", locatorToString));
        }

        String locatorType = locatorSplit[0];
        String locatorValue = locatorSplit[1];

        return switch (locatorType) {
            case "By.cssSelector" -> By.cssSelector(locatorValue);
            case "By.id" -> By.id(locatorValue);
            case "By.linkText" -> By.linkText(locatorValue);
            case "By.partialLinkText" -> By.partialLinkText(locatorValue);
            case "By.tagName" -> By.tagName(locatorValue);
            case "By.name" -> By.name(locatorValue);
            case "By.className" -> By.className(locatorValue);
            case "By.xpath" -> By.xpath(locatorValue);
            default ->
                    throw new IllegalStateException("Cannot define locator for WebElement definition " + locatorToString);
        };
    }
}
