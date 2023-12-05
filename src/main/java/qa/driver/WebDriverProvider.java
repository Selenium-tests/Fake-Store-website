package qa.driver;

import org.reflections.Reflections;
import qa.enums.Browser;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class WebDriverProvider {

    public static WebDriverFactory getFactory(Browser browser) {

        String packages = WebDriverFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends WebDriverFactory>> factories = reflections.getSubTypesOf(WebDriverFactory.class);

        Class<? extends WebDriverFactory> factory = factories
                .stream()
                .filter(i -> i.getName().toLowerCase().contains(browser.name().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find factory with name: " + browser.getName()));

        String factoryName = factory.getName();

        try {

            return (WebDriverFactory) Class.forName(factoryName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {

            throw new IllegalStateException(e);
        }
    }
}
