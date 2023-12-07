package qa.helpers.fillers;

import org.openqa.selenium.WebDriver;
import qa.enums.CreditCardFormMethods;
import qa.pages.checkout.CreditCardForm;
import qa.utils.MethodsRetriever;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

public class CreditCardFormFiller {

    private static final String[] data ={
            "332",
            "4242424242424242",
            "09/25"
    };

    public static CreditCardForm fill(WebDriver driver, CreditCardFormMethods omitted) {

        MethodsRetriever<CreditCardForm> retriever = new MethodsRetriever<>(CreditCardForm.class);
        Method[] methods = retriever.getMethods();
        CreditCardForm creditCardForm = new CreditCardForm(driver);

        IntStream.range(0, methods.length)
                .filter(i -> !methods[i].getName().toLowerCase().contains(omitted.getName().toLowerCase()))
                .forEach(i -> {
                    try {
                        methods[i].invoke(creditCardForm, data[i]);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

        return creditCardForm;
    }
}
