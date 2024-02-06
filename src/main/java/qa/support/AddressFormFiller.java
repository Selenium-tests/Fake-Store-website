package qa.support;

import org.openqa.selenium.WebDriver;
import qa.enums.AddressFormMethods;
import qa.pages.addressform.AddressForm;
import qa.support.MethodsRetriever;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

public class AddressFormFiller {

    private static final String[] data = {
            "Koszarska 2a",
            "Klatka D",
            "Koszalin",
            "2a MaxArt",
            "annkoczuba@gmail.com",
            "Anna",
            "Koczuba",
            "111222333 ",
            "45-400"
    };

    public static AddressForm fill(WebDriver driver, AddressFormMethods omitted) throws InvocationTargetException, IllegalAccessException {

        MethodsRetriever<AddressForm> retriever = new MethodsRetriever<>(AddressForm.class);
        Method[] methods = retriever.getMethods();
        AddressForm addressForm = new AddressForm(driver, "billing");

        IntStream.range(0, methods.length)
                .filter(i -> !methods[i].getName().toLowerCase().contains(omitted.getName().toLowerCase()))
                .forEach(i -> {
                    try {
                        methods[i].invoke(addressForm, data[i]);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

        return addressForm;
    }
}
