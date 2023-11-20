package qa.tobyclass;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ByFinder {

    private static final String BY = "by";
    private static final String LOCATOR = "locator";
    private static final String FOUND_BY = "foundBy";

    public static By getByFromWebElement(WebElement element) throws IllegalAccessException {

        if (element instanceof Proxy proxy) {

            InvocationHandler handler = Proxy.getInvocationHandler(proxy);

            Object field = FieldUtils.readField(handler, LOCATOR, true);
            Object locator = FieldUtils.readField(field, BY, true);

            return ByFromString.getByFromString(locator.toString());

        } else if (element instanceof RemoteWebElement webElement) {

            Object field = FieldUtils.readField(webElement, FOUND_BY, true);
            String[] split = field.toString().split("-> ");

            return ByFromString.getByFromString(split[1]);

        } else {

            return null;
        }

    }
}